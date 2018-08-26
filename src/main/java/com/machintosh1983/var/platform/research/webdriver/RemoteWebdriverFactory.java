package com.machintosh1983.var.platform.research.webdriver;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.machintosh1983.var.platform.common.ErrorCode;
import com.machintosh1983.var.platform.research.webdriver.config.DriverPoolConfiguration;
import com.machintosh1983.var.platform.research.webdriver.service.HeadlessWebdriverService;

/**
 * 
 * @author Machintosh1983
 *
 */
public class RemoteWebdriverFactory  implements WebdriverFactory {	
	private Logger logger = Logger.getLogger(getClass());

	private HeadlessWebdriverService service;
	private GenericObjectPool<WebDriver> pool;
	
	public RemoteWebdriverFactory(HeadlessWebdriverService service, DriverPoolConfiguration config) {
		this.service = service;
		try {
			this.service.createAndStartService();
		} catch (Exception e) {
			logger.error(ErrorCode._9100(this.service.toString()), e);
			System.exit(1);
		}
		
		 GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
         poolConfig.setMaxIdle(config.getMaxIdle());
         poolConfig.setMaxTotal(config.getMaxTotal());
         poolConfig.setTestOnBorrow(config.getTestOnBorrow());
         poolConfig.setTestOnReturn(config.getTestOnReturn());
         poolConfig.setMinIdle(config.getMinIdle());
         poolConfig.setLifo(config.getLifo());
         
		pool = new GenericObjectPool<WebDriver>( this.service, poolConfig );
	}
	
	@Override
	public WebDriver getWebdriver() {
		try {
			return pool.borrowObject();
		} catch (Exception e) {
			logger.error(ErrorCode._9000(), e);
			return null;
		}
	}

	@Override
	public void close(WebDriver driver) {
		pool.returnObject(driver);
	}

	@Override
	public void addDriverIntoPool() {
		try {
			pool.addObject();
		} catch (Exception e) {
			logger.error(ErrorCode._9200(), e);
		}		
	}

	
}

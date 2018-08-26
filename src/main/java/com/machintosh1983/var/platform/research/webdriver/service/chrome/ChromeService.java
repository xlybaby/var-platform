package com.machintosh1983.var.platform.research.webdriver.service.chrome;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.machintosh1983.var.platform.research.webdriver.service.HeadlessWebdriverService;

/**
 * 
 * @author Machintosh1983
 *
 */
public class ChromeService  extends HeadlessWebdriverService {
	Logger logger = Logger.getLogger( getClass() );
	
	private ChromeDriverService service;
	private String driverpath;
	private int port;
	
	public ChromeService( String driverpath, int port ) {
		this.driverpath = driverpath;
		this.port = port;
	}
	
	@Override
	public void createAndStartService() throws IOException {
		File driverFile = new File(driverpath);
		if (!driverFile.exists())
			throw new FileNotFoundException("Can't find chrome driver in path: " + driverpath);

		service = new ChromeDriverService.Builder().usingDriverExecutable(driverFile).usingPort(port).build();
		service.start();
		logger.info("Remote chrome driver service start on: " + service.getUrl().toString());
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			
			public void run() {
				try {
					createAndStopService() ;
				} catch ( Exception e ) {
					logger.error(e);
				}
			}
			
		});
	}

	public void createAndStopService() {
		service.stop();
	}

	@Override
	public WebDriver create() throws Exception {
		logger.info("Call create driver");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		options.addArguments("--window-size=1280x100");
		
		RemoteWebDriver driver = new RemoteWebDriver( service.getUrl(), options );
		return driver;
	}

	@Override
	public PooledObject<WebDriver> wrap(WebDriver driver) {
		return new DefaultPooledObject<WebDriver>(driver);
	}

	@Override
	public void passivateObject(PooledObject<WebDriver> po) throws Exception {
		// TODO Auto-generated method stub
		//super.passivateObject(p);
		WebDriver driver = po.getObject();
		driver.get("about:blank");
		Dimension rectnew = new Dimension( 1280, 100 );
		driver.manage().window().setSize(rectnew);
	}

	public String toString() {
		return "driver: " + this.driverpath +" port: "+ this.port;
	}
}

package com.machintosh1983.var.platform.research.webdriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.machintosh1983.var.platform.research.webdriver.config.DriverPoolConfiguration;
import com.machintosh1983.var.platform.research.webdriver.service.ChromeService;
import com.machintosh1983.var.platform.research.webdriver.service.HeadlessWebdriverService;
import com.machintosh1983.var.platform.research.webdriver.util.DriverContainer;

@Configuration
public class Builder {
	
	@Autowired
	private DriverPoolConfiguration driverPoolConfiguration;
	
	@Value("${var.platform.research.webdriver.driverpath:/usr/local/bin/chromedriver}")
	private String driverpath;

	@Value("${var.platform.research.webdriver.port:3333}")
	private int port;
	
	@Value("${var.platform.research.webdriver.pool.iniNum:1}")
	private int iniNum;
	
	@Value("${var.platform.research.webdriver.container.queueNum:5}")
	private int queuenum;
	
	@Value("${var.platform.research.webdriver.container.refreshInterval:60000}")
	private int refreshInterval;
	
	@Bean
	public WebdriverFactory webdriverFactory() {
		HeadlessWebdriverService service = new ChromeService(driverpath, port);
		WebdriverFactory factory = new RemoteWebdriverFactory(service, driverPoolConfiguration);
		for( int i = 0; i < iniNum; i++ ) {
			factory.addDriverIntoPool();
		}
		return factory;
	}
	
	@Bean
	public DriverContainer driverContainer( WebdriverFactory webdriverFactory ) {
		DriverContainer container = new DriverContainer( webdriverFactory, queuenum, refreshInterval );
		return container;
	}
}

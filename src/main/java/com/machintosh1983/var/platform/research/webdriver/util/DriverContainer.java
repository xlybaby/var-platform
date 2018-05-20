package com.machintosh1983.var.platform.research.webdriver.util;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.machintosh1983.var.platform.common.ErrorCode;
import com.machintosh1983.var.platform.research.webdriver.WebdriverFactory;

public class DriverContainer {
	private Logger logger = Logger.getLogger(getClass());

	private WebdriverFactory factory;
	//private Map<String, wrapper> container;
	private ScheduledThreadPoolExecutor exer;
	
	//private LinkedBlockingQueue<List<WebDriver>> series;
	private LinkedBlockingDeque<List<WebDriver>> series;
	
	public DriverContainer(WebdriverFactory factory, int queuenum, int interval) {
		this.factory = factory;
		this.series = new LinkedBlockingDeque<List<WebDriver>>(queuenum);
		initQueue(interval);
	}
	
	public void submit(WebDriver driver) {
		List<WebDriver> l = series.peekLast();
		if( l != null ) {
			l.add(driver);
		}
	}
	
	private void initQueue(int interval) {
		//fillfull this queue, u mother fucker
		for(int i=0;i<series.remainingCapacity();i++) {
			List<WebDriver> l = new LinkedList<WebDriver>();
			series.offer(l);
		}
		
		exer = new ScheduledThreadPoolExecutor(1);
		exer.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				try {
					if ( series.size() > 0 ) {
						List<WebDriver> l = new LinkedList<WebDriver>();
						List<WebDriver> removed = series.remove();
						series.offer(l);
						
						if( removed != null ) {
							for(int i=0; i<removed.size();i++) {
								WebDriver driver = removed.get(i);
								factory.close(driver);
								removed.remove(driver);
							}
							removed = null;
						}
					}
					
				} catch ( Exception e ) {
					logger.error(ErrorCode._8000(), e);
				}
			}
		}, interval, interval, TimeUnit.MILLISECONDS	);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				if( exer.isShutdown() ) {
					exer.shutdownNow();
				}
			}
			
		});
	}
	
	class wrapper {
		private WebDriver driver;
		private long expire;
		
		public wrapper(WebDriver driver, long expire) {
			this.driver = driver;
			this.expire = expire;
		}
	}
}

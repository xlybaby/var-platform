package com.machintosh1983.var.platform.research.webdriver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="var.platform.research.webdriver.pool")
public class DriverPoolConfiguration {
	
	 private int maxIdle;
	 private int maxTotal;
	 private boolean testOnBorrow;
	 private boolean testOnReturn;
	 private int minIdle;
	 private boolean lifo;
	 
	public int getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	public int getMaxTotal() {
		return maxTotal;
	}
	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}
	public boolean getTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public boolean getTestOnReturn() {
		return testOnReturn;
	}
	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	public int getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	public boolean getLifo() {
		return lifo;
	}
	public void setLifo(boolean lifo) {
		this.lifo = lifo;
	}
	 
	 
}

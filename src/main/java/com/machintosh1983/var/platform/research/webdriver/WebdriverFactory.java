package com.machintosh1983.var.platform.research.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebdriverFactory {
	public WebDriver getWebdriver();
	public void close(WebDriver driver);
	public void addDriverIntoPool();
	//public void init();
}

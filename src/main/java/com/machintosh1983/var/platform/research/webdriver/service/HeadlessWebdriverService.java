package com.machintosh1983.var.platform.research.webdriver.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class HeadlessWebdriverService extends BasePooledObjectFactory<WebDriver> {

	public abstract void createAndStartService() throws IOException;

	public abstract void createAndStopService();
}

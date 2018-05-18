package com.machintosh1983.var.platform.research.template.service;

import java.io.File;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.machintosh1983.var.platform.research.template.model.Element;
import com.machintosh1983.var.platform.research.template.model.Selector;
import com.machintosh1983.var.platform.research.webdriver.WebdriverFactory;

/**
 * 
 * @author Machintosh1983
 *
 */
public abstract class HeadlessBrowserUsageService {

	private int default_screen_window_width = 1280;
	private int default_screen_window_height = 700;
	
	@Autowired
	private WebdriverFactory webdriverFactory;
	
	public Element findElement(Selector selector) {
		Element e = null;
		
		return e;
	}
	
	public File takeWholePageCapture(String url) {
		RemoteWebDriver driver = (RemoteWebDriver)webdriverFactory.getWebdriver();
		driver.get(url);
		long height = (long)driver.executeScript("return document.body.clientHeight;");
		Dimension rect = driver.manage().window().getSize();
		
		Dimension rectnew = new Dimension( rect.width, (int)height );
		driver.manage().window().setSize(rectnew);
		File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
		webdriverFactory.close(driver);
		
		return screenshotFile;
	}
}

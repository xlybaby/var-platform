package com.machintosh1983.var.platform.research.webdriver.service.utility;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.machintosh1983.var.platform.common.Constant;
import com.machintosh1983.var.platform.research.webdriver.WebdriverFactory;
import com.machintosh1983.var.platform.research.webdriver.model.Element;
import com.machintosh1983.var.platform.research.webdriver.model.Selector;
import com.machintosh1983.var.platform.research.webdriver.util.DriverContainer;

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
	
	@Autowired
	private DriverContainer driverContainer;
	
	public Element findElement(WebDriver driver, Selector selector) {
		Element e = null;
		
		return e;
	}
	
	public File takeWholePageCapture( String url, HttpServletRequest request, boolean keep ) {
		RemoteWebDriver driver = (RemoteWebDriver)webdriverFactory.getWebdriver();
		driver.get(url);
		long height = (long)driver.executeScript("return document.body.clientHeight;");
		Dimension rect = driver.manage().window().getSize();
		
		Dimension rectnew = new Dimension( rect.width, (int)height );
		driver.manage().window().setSize(rectnew);
		File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
		if ( keep ) {
			driverContainer.submit(driver);
			HttpSession session = request.getSession();
			session.setAttribute(Constant.HTTP_SESSION_KEY_DRIVER, driver);
		} else
			webdriverFactory.close(driver);
		
		return screenshotFile;
	}
	
	public WebdriverFactory getWebdriverFactory() {
		return this.webdriverFactory;
	}

}

package com.machintosh1983.var.platform.research.template.controller.custom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.machintosh1983.var.platform.common.Constant;
import com.machintosh1983.var.platform.research.template.model.Element;
import com.machintosh1983.var.platform.research.template.model.Selector;
import com.machintosh1983.var.platform.research.template.service.HeadlessBrowserUsageService;
import com.machintosh1983.var.platform.research.webdriver.util.DriverContainer;

/**
 * 
 * @author Machintosh1983
 *
 */
@RestController
@RequestMapping("/template")
public class UserCustomTemplateController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private HeadlessBrowserUsageService locateElementInWebpageSnapshotService;
	
	@RequestMapping(value="/capture", method=RequestMethod.GET)
	public void getPageSnapshot( @RequestParam(name="location", required=true) String location, HttpServletRequest request, HttpServletResponse response ) {
		File snapshot = locateElementInWebpageSnapshotService.takeWholePageCapture(location, request, true);
		if( snapshot != null ) {
			response.setContentType("image/png");
			
			OutputStream out = null;
			FileInputStream fin = null;
			try {
				out = response.getOutputStream();
				fin = new FileInputStream(snapshot);
				byte[] bytes = new byte[50];
				int reads;
				while((reads=fin.read(bytes)) > 0) {
					out.write(bytes);
					out.flush();
				}
				
			} catch (IOException e) {
				logger.error("Output", e);
			} finally {
				if( out != null )
					try {
						out.close();
					} catch (IOException e) {}
				if( fin != null )
					try {
						fin.close();
					} catch (IOException e) {}
			}
		}
	}
	
	@RequestMapping(value="/locateone", method=RequestMethod.POST)
	public Element locateElementUserClicked( @RequestBody Selector selector, HttpServletRequest request ) {
		HttpSession session = request.getSession();
		WebDriver driver = (WebDriver)session.getAttribute(Constant.HTTP_SESSION_KEY_DRIVER);
		if (driver == null )
			return null;
		
		Element e = locateElementInWebpageSnapshotService.findElement(driver, selector);
		return e;
	}
	
	public Map<String, Object> customTemplateUsePageSnapshot( @RequestBody Selector selector ) {
		return null;
	}
}

package com.machintosh1983.var.platform.research.template.controller.custom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.machintosh1983.var.platform.common.Constant;
import com.machintosh1983.var.platform.common.ResultMap;
import com.machintosh1983.var.platform.research.template.controller.custom.vo.PageComponent;
import com.machintosh1983.var.platform.research.template.model.Scenario;
import com.machintosh1983.var.platform.research.template.model.User;
import com.machintosh1983.var.platform.research.template.model.cast.Element;
import com.machintosh1983.var.platform.research.template.model.cast.Selector;
import com.machintosh1983.var.platform.research.template.model.performance.Schedule;
import com.machintosh1983.var.platform.research.template.model.performance.UILayout;
import com.machintosh1983.var.platform.research.template.service.HeadlessBrowserUsageService;
import com.machintosh1983.var.platform.research.template.service.UserCustomTemplateService;
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
	
	@Autowired
	private UserCustomTemplateService userCustomTemplateService;
	
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
	
	@RequestMapping(value="/banner/submit", method=RequestMethod.POST)
	public ResultMap<Scenario> submitBannerScenario( @RequestBody List<Scenario> scenarios, HttpServletRequest request ) {
		ResultMap<Scenario> result=null;
		User u = new User();
		u.setUserId(10000);
		
		return result;
	}
	
	@RequestMapping(value="/ranker/submit", method=RequestMethod.POST)
	public ResultMap<Scenario> submitRankerScenario( @RequestBody List<PageComponent> pageComponents, HttpServletRequest request ) {
		ResultMap<Scenario> result=null;
		
		return result;
	}
	
	@RequestMapping(value="/subscriber/submit", method=RequestMethod.POST)
	public ResultMap<Scenario> submitSubscriberScenario( @RequestBody List<PageComponent> pageComponents, HttpServletRequest request ) {
		ResultMap<Scenario> result=null;
		
		return result;
	}
	
	@RequestMapping(value="/timeseries/submit", method=RequestMethod.POST)
	public ResultMap<Scenario> submitTimeseriesScenario( @RequestBody List<PageComponent> pageComponents, HttpServletRequest request ) {
		ResultMap<Scenario> result=null;
		
		return result;
	}
	
	@RequestMapping(value="/corpus/submit", method=RequestMethod.POST)
	public ResultMap<Scenario> submitCorpusScenario( @RequestBody List<PageComponent> pageComponents, HttpServletRequest request ) {
		ResultMap<Scenario> result=null;
		
		return result;
	}
	
	@RequestMapping(value="/banner/preview", method=RequestMethod.POST)
	public ResultMap<Scenario> detectBannerComponents( @RequestBody List<PageComponent> pageComponents, HttpServletRequest request ) {
		ResultMap<Scenario> result=null;
		
		return result;
	}
	
	public static void main( String[] args ) {
		CleanerProperties props = new CleanerProperties();
		 
		// set some properties to non-default values
		props.setTranslateSpecialEntities(true);
		props.setTransResCharsToNCR(true);
		props.setOmitComments(true);
		
		try {
			TagNode tagNode = new HtmlCleaner().clean(
				    new URL("http://www.rayli.com.cn/")
				);
			Object[] objarr = tagNode.evaluateXPath("//*[@id='body_adv']/div[5]/div[1]/div[1]/div/div/div");
			for(Object obj: objarr)
				System.out.println(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPatherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

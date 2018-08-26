package com.machintosh1983.var.platform.research.webdriver.service.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.springframework.stereotype.Service;

import com.machintosh1983.var.platform.research.webdriver.model.Element;
import com.machintosh1983.var.platform.research.webdriver.model.Selector;

/**
 * 
 * @author Machintosh1983
 *
 */
@Service("locateElementInWebpageSnapshotService")
public class LocateElementInWebpageSnapshotService extends HeadlessBrowserUsageService {
	private Logger logger = Logger.getLogger(getClass());

	private int max_search_deep_level = -1;
	
	@Override
	public Element findElement(WebDriver driver, Selector selector) {
		if( driver == null )
			return null;
		
		int x = selector.getLocateX();
		int y = selector.getLocateY();
		
		RemoteWebElement element = (RemoteWebElement)((RemoteWebDriver)driver).executeScript(
				"function findElementByUserClickPosition(parent, x, y, curdeep, stopdeep) {\n" + 
				"	curdeep++;\n" + 
				"	if ( stopdeep > 0 && curdeep >= stopdeep )\n" + 
				"		return parent;\n" + 
				"	var children = parent.childNodes;\n" + 
				"	for(var i=0; i<children.length; i++) {\n" + 
				"		var child = children[i];\n" + 
				"		if (!child.getBoundingClientRect)\n" + 
				"			continue;\n" + 
				"		var rect = child.getBoundingClientRect();\n" + 
				"		var left = rect['x'];\n" + 
				"		var top;\n" + 
				"		var width = rect['width'];\n" + 
				"		var height = rect['height'];\n" + 
				"		var offsetTop = child.offsetTop;\n" + 
				"		if (width < 0 || height < 0)\n" + 
				"			continue;\n" + 
				"  		if (child.style.display==\"none\" || child.style.visible==\"hidden\")\n" + 
				"  			continue;\n" + 
				"		if ( (left+width) < x)\n" + 
				"			continue;\n" + 
				"    	var absy = 0;\n" + 
				"    	var current = child;\n" + 
				"    	while(current) {\n" + 
				"        	absy += current.offsetTop;\n" + 
				"        	current = current.offsetParent;\n" + 
				"    	}\n" + 
				"    	if ( (absy+height) < y ) {\n" + 
				"    		continue;\n" + 
				"    	}\n" + 
				"		var hasEleChild=false;\n" + 
				"		var allChild = child.childNodes;\n" + 
				"		for(var j=0;j<allChild.length;j++) {\n" + 
				"			if (allChild[j].nodeType==1){\n" + 
				"				hasEleChild=true;\n" + 
				"				break;\n" + 
				"			}\n" + 
				"		}\n" + 
				"		if (hasEleChild)\n" + 
				"			return findElementByUserClickPosition(child, x, y, curdeep, stopdeep);\n" + 
				"		else\n" + 
				"			return child;\n" + 
				"	}\n" + 
				"	return parent;\n" + 
				"}\n" + 
				"function startFindElementByUserClickPosition(x, y, curdeep, stopdeep) {\n" + 
				"	var ebody = document.getElementsByTagName(\"body\");\n" + 
				"	var target;\n" + 
				"	if ( ebody && ebody.length > 0 )\n" + 
				"		target = findElementByUserClickPosition(ebody[0], x, y, 0, -1);\n" + 
				"	return target;\n" + 
				"}\n" + 
				"return startFindElementByUserClickPosition(arguments[0],arguments[1],arguments[2],arguments[3]);",
				x, y, 0, -1);
		//logger.info(x + "," + y);
		if ( element != null ) {
			logger.info( "<" + element.getTagName() +" id='"+ element.getId() +"' class='"+ element.getClass() +"'>"+ element.getText() +"</"+element.getTagName()+">") ;
			
		}		
		return null;
	}

	 
}

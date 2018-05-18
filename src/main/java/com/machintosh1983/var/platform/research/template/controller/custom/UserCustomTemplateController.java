package com.machintosh1983.var.platform.research.template.controller.custom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.machintosh1983.var.platform.research.template.model.Selector;
import com.machintosh1983.var.platform.research.template.service.HeadlessBrowserUsageService;

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
	public void getPageSnapshot( @RequestParam(name="location", required=true) String location, HttpServletResponse response ) {
		File snapshot = locateElementInWebpageSnapshotService.takeWholePageCapture(location);
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
	
	public Map<String, Object> customTemplateUsePageSnapshot( @RequestBody Selector selector ) {
		return null;
	}
}

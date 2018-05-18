package com.machintosh1983.var.platform.research.template.service;

import java.io.File;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.machintosh1983.var.platform.research.template.model.Scene;
import com.machintosh1983.var.platform.research.template.model.Template;
import com.machintosh1983.var.platform.research.template.model.User;

/**
 * 
 * @author Machintosh1983
 *
 */
public abstract class AbstractTemplateService {
	
	public void generateTemplate(Scene scene) {
		
	}
	
	public List<Template> getUserTemplates(User user) {
		List<Template> templates=null;
		
		return templates;
	}
	
	public Template getUserTemplates(User user, Template vo) {
		Template template = null;
		
		return template;
	}
	
}

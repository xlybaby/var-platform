package com.machintosh1983.var.platform.research.template.service;

import java.util.List;

import com.machintosh1983.var.platform.research.template.controller.custom.vo.PageComponent;
import com.machintosh1983.var.platform.research.template.model.Scenario;
import com.machintosh1983.var.platform.research.template.model.User;

public interface UserCustomTemplateService {

	public List<Scenario> getUserTemplates(User user);
	public Scenario submitUserCustomScenario( PageComponent component );
	public Scenario submitUserCustomScenario( Scenario Scenario );

}

package com.machintosh1983.var.platform.research.template.model;

import java.util.Map;

public class Selector {

	private int locateX;
	private int locateY;
	
	private String tagName;
	private String id;
	private String clazz;
	private String name;
	private String xpath;
	
	private Map<String, String> attrs;
	
	public int getLocateX() {
		return locateX;
	}
	
	public void setLocateX(int locateX) {
		this.locateX = locateX;
	}
	
	public int getLocateY() {
		return locateY;
	}
	
	public void setLocateY(int locateY) {
		this.locateY = locateY;
	}
	
}

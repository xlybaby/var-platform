package com.machintosh1983.var.platform.research.template.model.cast;

import java.util.Map;

public class Actor {
	
	private int type;
	private Selector selector;
	private Map<String, Object> properties;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Selector getSelector() {
		return selector;
	}
	public void setSelector(Selector selector) {
		this.selector = selector;
	}
	public Map<String, Object> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
}

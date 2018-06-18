package com.machintosh1983.var.platform.research.template.model.cast;

import java.util.Map;

public class Selector {
	
	private String id;
	private String name;
	private String tag;
	private String clazz;
	private String xpath;
	private String css;
	private String text;
	private int locateX;
	private int locateY;

	private Map<String, String> attributes;
	
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getXpath() {
		return xpath;
	}
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
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

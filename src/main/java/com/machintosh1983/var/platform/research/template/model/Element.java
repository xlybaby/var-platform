package com.machintosh1983.var.platform.research.template.model;

public class Element {

	private Selector selector;
	private int nodeType;
	
	public Element(Selector selector ) {
		this.selector = selector;
	}

	public Selector getSelector() {
		return selector;
	}

	public int getNodeType() {
		return nodeType;
	}
	
}

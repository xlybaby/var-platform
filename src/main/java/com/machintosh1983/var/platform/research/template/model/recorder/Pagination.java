package com.machintosh1983.var.platform.research.template.model.recorder;

import com.machintosh1983.var.platform.research.template.model.cast.Selector;

public class Pagination {
	
	private int maxpageno=10;
	private Selector selector;
	private Selector parent;
	
	public int getMaxpageno() {
		return maxpageno;
	}
	public void setMaxpageno(int maxpageno) {
		this.maxpageno = maxpageno;
	}
	public Selector getSelector() {
		return selector;
	}
	public void setSelector(Selector selector) {
		this.selector = selector;
	}
	public Selector getParent() {
		return parent;
	}
	public void setParent(Selector parent) {
		this.parent = parent;
	}
	
	
}

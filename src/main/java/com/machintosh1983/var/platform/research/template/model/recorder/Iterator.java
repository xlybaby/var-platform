package com.machintosh1983.var.platform.research.template.model.recorder;

import java.util.List;

import com.machintosh1983.var.platform.research.template.model.cast.Selector;

public class Iterator {

	private List<Item> items;
	private Selector selector;

	public Selector getSelector() {
		return selector;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}

package com.machintosh1983.var.platform.research.template.model.recorder;

import java.util.List;

import com.machintosh1983.var.platform.research.template.model.cast.Selector;

public class Container {
	
	private Selector selector;
	private List<Iterator> iterators;

	public Selector getSelector() {
		return selector;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}

	public List<Iterator> getIterators() {
		return iterators;
	}

	public void setIterators(List<Iterator> iterators) {
		this.iterators = iterators;
	}
	
}

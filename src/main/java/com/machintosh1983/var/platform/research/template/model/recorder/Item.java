package com.machintosh1983.var.platform.research.template.model.recorder;

import com.machintosh1983.var.platform.research.template.model.cast.Selector;

public class Item {

	private Selector selector;
    
    private int link;
    private int extract;
    private String nextPageLink;
    
    private int img;
    private int index;
    
	public void setLink(int link) {
		this.link = link;
	}

	public int getExtract() {
		return extract;
	}

	public void setExtract(int extract) {
		this.extract = extract;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public int getLink() {
		return link;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Selector getSelector() {
		return selector;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}

	public String getNextPageLink() {
		return nextPageLink;
	}

	public void setNextPageLink(String nextPageLink) {
		this.nextPageLink = nextPageLink;
	}

	
}

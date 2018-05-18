package com.machintosh1983.var.platform.research.template.service;

import org.springframework.stereotype.Service;

import com.machintosh1983.var.platform.research.template.model.Element;
import com.machintosh1983.var.platform.research.template.model.Selector;

/**
 * 
 * @author Machintosh1983
 *
 */
@Service("locateElementInWebpageSnapshotService")
public class LocateElementInWebpageSnapshotService extends HeadlessBrowserUsageService {

	private int max_search_deep_level = -1;
	
	@Override
	public Element findElement(Selector selector) {
		int x = selector.getLocateX();
		int y = selector.getLocateY();
		
		return null;
	}

	 
}

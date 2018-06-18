package com.machintosh1983.var.platform.research.template.model.performance;

import java.util.concurrent.TimeUnit;

public class Schedule {
	
	private int interval;
	private TimeUnit unit;
	
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public TimeUnit getUnit() {
		return unit;
	}
	public void setUnit(TimeUnit unit) {
		this.unit = unit;
	}
	
	
}

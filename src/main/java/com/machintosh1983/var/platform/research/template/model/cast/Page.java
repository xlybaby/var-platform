package com.machintosh1983.var.platform.research.template.model.cast;

import java.util.List;

import com.machintosh1983.var.platform.research.template.model.recorder.Pagination;

public class Page {

	//private long taskId;
	private String pageId;
	
	private List<Actor> actors;
	private Pagination pagination;
	
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public Pagination getPagination() {
		return this.pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

//	public long getTaskId() {
//		return taskId;
//	}
//
//	public void setTaskId(long taskId) {
//		this.taskId = taskId;
//	}

	public String getPageId() {
		return this.pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	
}

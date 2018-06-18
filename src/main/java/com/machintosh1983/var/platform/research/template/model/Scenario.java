package com.machintosh1983.var.platform.research.template.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.machintosh1983.var.platform.common.Constant;
import com.machintosh1983.var.platform.research.template.model.cast.Page;
import com.machintosh1983.var.platform.research.template.model.cast.Scene;
import com.machintosh1983.var.platform.research.template.model.cast.Selector;
import com.machintosh1983.var.platform.research.template.model.cast.Actor;
import com.machintosh1983.var.platform.research.template.model.performance.Schedule;
import com.machintosh1983.var.platform.research.template.model.performance.UILayout;
import com.machintosh1983.var.platform.research.template.model.recorder.Container;
import com.machintosh1983.var.platform.research.template.model.recorder.Item;
import com.machintosh1983.var.platform.research.template.model.recorder.Iterator;
import com.machintosh1983.var.platform.research.template.model.recorder.Pagination;
import com.machintosh1983.var.platform.research.template.model.recorder.RecordComponent;

/**
 * 
 * @author Machintosh1983
 *
 */
public class Scenario {

	private User user;
	
	private String scenarioId;
	private int scenarioType;
	private String title;
	private Schedule schedule;
	private int publish;
	private UILayout layout;
	
	private int maxDuration=5*60;
	private int maxThreadNum=3;
	
	private List<Scene> scenelist;

	private Date createTime;
	private Date lastUpdateTime;
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(String scenarioId) {
		this.scenarioId = scenarioId;
	}

	public List<Scene> getScenelist() {
		return scenelist;
	}

	public void setScenelist(List<Scene> scenelist) {
		this.scenelist = scenelist;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getScenarioType() {
		return scenarioType;
	}

	public String getScenarioTypeName() {
		
		switch (this.scenarioType) {
		case Constant.VAR_SCENARIO_TYPE_TIMESERIES:
			return "TIMESERIES";
		case Constant.VAR_SCENARIO_TYPE_REFRESHBLOCK:
			return "REFRESHBLOCK";
		case Constant.VAR_SCENARIO_TYPE_RANKLIST:
			return "RANKLIST";
		case Constant.VAR_SCENARIO_TYPE_CORPUSCOLLECT:
			return "CORPUSCOLLECT";
		case Constant.VAR_SCENARIO_TYPE_BANNER:
			return "BANNER";
			
		default: return "UNKNOWN";
		}
	}
	
	public void setScenarioType(int scenarioType) {
		this.scenarioType = scenarioType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int isPublish() {
		return publish;
	}

	public void setPublish(int publish) {
		this.publish = publish;
	}

	public UILayout getLayout() {
		return layout;
	}

	public void setLayout(UILayout layout) {
		this.layout = layout;
	}
	
	public int getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public int getMaxThreadNum() {
		return maxThreadNum;
	}

	public void setMaxThreadNum(int maxThreadNum) {
		this.maxThreadNum = maxThreadNum;
	}
/**
	public static void main( String[] args ) {
		
		Scenario scenario = new Scenario();
		
		scenario.setScenarioId("0d3e3b36-10a8-46c3-88cb-1e4b00136a6f");
		scenario.setPublish(0);
		scenario.setScenarioType(Constant.VAR_SCENARIO_TYPE_CORPUSCOLLECT);
		scenario.setTitle("test scenario");
		
//		Schedule schedule = new Schedule();
//		schedule.setInterval(1);
//		schedule.setUnit(TimeUnit.HOURS);
//		scenario.setSchedule(schedule);
		
		UILayout layout = new UILayout();
		layout.setContentHeight(100);
		layout.setContentWidth(100);
		layout.setOffsetParentLeft(10);
		layout.setOffsetParentTop(10);
		scenario.setLayout(layout);
		
		User usr = new User();
		usr.setUserId(10001l);
		usr.setUserName("test");
		usr.setRoleId(10001);
		scenario.setUser(usr);
		
		List<Scene> scenelist = new ArrayList<Scene>();
		for(int i=0; i<1; i++) {
			Scene scene = new Scene();
			scene.setHref("http://drugs.dxy.cn/index.htm");
			
			List<Page> pages = new ArrayList<Page>();
			for(int j=0; j<2;j++) {
				if(j==1 ) {
					Page page = new Page();
					//pageComponent.setTaskId(scenario.getScenarioId());
					page.setPageId(scenario.getScenarioId() + "_page" + j);
					
					Pagination pagination = new Pagination();
					Selector pagisel = new Selector();
					pagisel.setTag("a");
					Map<String, String> attrs = new HashMap<String, String>();
					attrs.put("title", "下一页");
					pagisel.setAttributes(attrs);
					Selector pagiprntsel = new Selector();
					pagiprntsel.setClazz("pagination");
					pagiprntsel.setTag("div");
					pagination.setSelector(pagisel);
					pagination.setParent(pagiprntsel);
					page.setPagination(pagination);
					
					List<Actor> actors = new ArrayList<Actor>();
					//Add one actor
					Actor act = new Actor();
					Map<String, Object> actproperties = new HashMap<String, Object>();
					act.setType(Constant.VAR_ACTOR_TYPE_RECORDING);
					Selector selector = new Selector();
					act.setSelector(selector);
					
					
					List<RecordComponent> reccomps = new ArrayList<RecordComponent>();
					RecordComponent recorder = new RecordComponent();
					List<Container> containers = new ArrayList<Container>();
					for(int c=0; c<1; c++) {
						Container container = new Container();
						Selector selcon = new Selector();
						//selcon.setName("cate_div");
						selcon.setClazz("common_main");
						container.setSelector(selcon);
						List<Iterator> iterators = new ArrayList<Iterator>();
						for(int it=0; it<1; it++) {
							Iterator iterator = new Iterator();
							Selector itersel = new Selector();
							itersel.setTag("li");
							iterator.setSelector(itersel);
							List<Item> items = new ArrayList<Item>();
							for(int t=0;t<1;t++) {
								Item item = new Item();
								Selector itemsel = new Selector();
								itemsel.setTag("a");;
								item.setLink(1);
								item.setExtract(1);
								
								item.setSelector(itemsel);
								items.add(item);
							}
							iterator.setItems(items);
							iterators.add(iterator);
						}
						container.setIterators(iterators);
						containers.add(container);
						
					}
					
					recorder.setContainers(containers);
					reccomps.add(recorder);
					actproperties.put("pageComponent", reccomps);
					act.setProperties(actproperties);
					actors.add(act);
					//end add one actor
					
					page.setActors(actors);
					pages.add(page);
				}
				if( j==0 ) {
				Page page = new Page();
				//pageComponent.setTaskId(scenario.getScenarioId());
				page.setPageId(scenario.getScenarioId() + "_page" + j);
				
				List<Actor> actors = new ArrayList<Actor>();
				//Add one actor
				Actor act = new Actor();
				Map<String, Object> actproperties = new HashMap<String, Object>();
				act.setType(Constant.VAR_ACTOR_TYPE_RECORDING);
				Selector selector = new Selector();
				act.setSelector(selector);
				
				
				List<RecordComponent> reccomps = new ArrayList<RecordComponent>();
				RecordComponent recorder = new RecordComponent();
				List<Container> containers = new ArrayList<Container>();
				for(int c=0; c<1; c++) {
					Container container = new Container();
					Selector selcon = new Selector();
					selcon.setName("cate_div");
					container.setSelector(selcon);
					List<Iterator> iterators = new ArrayList<Iterator>();
					for(int it=0; it<1; it++) {
						Iterator iterator = new Iterator();
						Selector itersel = new Selector();
						itersel.setTag("li");
						iterator.setSelector(itersel);
						List<Item> items = new ArrayList<Item>();
						for(int t=0;t<1;t++) {
							Item item = new Item();
							Selector itemsel = new Selector();
							itemsel.setTag("a");;
							item.setLink(1);
							item.setExtract(1);
							item.setIndex(1);
							
							item.setSelector(itemsel);
							items.add(item);
						}
						iterator.setItems(items);
						iterators.add(iterator);
					}
					container.setIterators(iterators);
					containers.add(container);
					
				}
				
				recorder.setContainers(containers);
				reccomps.add(recorder);
				actproperties.put("pageComponent", reccomps);
				act.setProperties(actproperties);
				actors.add(act);
				//end add one actor
				
				page.setActors(actors);
				pages.add(page);
			}
			
			}
			scene.setPages(pages);
			scenelist.add(scene);

		}
		
		scenario.setScenelist(scenelist);
		System.out.println(JSONObject.toJSONString(scenario));
	}
	*/
	
}

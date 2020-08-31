package org.icbc.actions.userRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IUserManageService;
import org.icbc.tool.ResultUtils;

public class GetUserwithPageAction {
	private int page;
    private int limit;
    private IUserManageService userManageService;
    public String execute() throws IOException {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map=userManageService.getUserwithPage(page, limit);
    	map.put("status", "success");
    	ResultUtils.toJson(ServletActionContext.getResponse(), map);
    	return null;
    }
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public IUserManageService getUserManageService() {
		return userManageService;
	}
	public void setUserManageService(IUserManageService userManageService) {
		this.userManageService = userManageService;
	}
    
}

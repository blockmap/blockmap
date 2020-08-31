package org.icbc.actions.subinstitutionRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.ISubinstitutionService;
import org.icbc.tool.ResultUtils;

public class GetSubwithPageAction {
	private int page;
    private int limit;
    private ISubinstitutionService subinstitutionService;
    public String execute() throws IOException {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map=subinstitutionService.getSubinstitutionwithPage(page, limit);
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
	public ISubinstitutionService getSubinstitutionService() {
		return subinstitutionService;
	}
	public void setSubinstitutionService(ISubinstitutionService subinstitutionService) {
		this.subinstitutionService = subinstitutionService;
	}
    
}

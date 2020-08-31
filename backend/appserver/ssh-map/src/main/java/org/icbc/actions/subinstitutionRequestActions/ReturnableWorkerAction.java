package org.icbc.actions.subinstitutionRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.ISubinstitutionService;
import org.icbc.tool.ResultUtils;

public class ReturnableWorkerAction {
	Map<String,Object> map = new HashMap<>();
	private ISubinstitutionService subinstitutionService;
	public String execute() throws IOException {
		map = subinstitutionService.ReturnableWorker();
		map.put("status", "success");
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
		return null;
		
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public ISubinstitutionService getSubinstitutionService() {
		return subinstitutionService;
	}
	public void setSubinstitutionService(ISubinstitutionService subinstitutionService) {
		this.subinstitutionService = subinstitutionService;
	}
	
}

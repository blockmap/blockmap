package org.icbc.actions.subinstitutionRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.ISubinstitutionService;
import org.icbc.tool.ResultUtils;

public class DeleteSubinstitutionAction {
	private long id;
	private ISubinstitutionService subinstitutionService;
	public String execute() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		subinstitutionService.deleteSubinstitution(id);
		map.put("status", "success");
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
    	return null;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ISubinstitutionService getSubinstitutionService() {
		return subinstitutionService;
	}
	public void setSubinstitutionService(ISubinstitutionService subinstitutionService) {
		this.subinstitutionService = subinstitutionService;
	}
	
}

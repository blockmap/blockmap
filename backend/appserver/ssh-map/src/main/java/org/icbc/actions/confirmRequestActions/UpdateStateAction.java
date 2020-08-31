package org.icbc.actions.confirmRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IConfirmInformationService;
import org.icbc.tool.ResultUtils;

public class UpdateStateAction {
	private long id;
	private IConfirmInformationService confirmService;
	public String execute() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		confirmService.updatestate(id);
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
	public IConfirmInformationService getConfirmService() {
		return confirmService;
	}
	public void setConfirmService(IConfirmInformationService confirmService) {
		this.confirmService = confirmService;
	}
	
}

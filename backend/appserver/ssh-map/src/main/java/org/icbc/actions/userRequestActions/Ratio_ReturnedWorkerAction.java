package org.icbc.actions.userRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IUserManageService;
import org.icbc.tool.ResultUtils;

public class Ratio_ReturnedWorkerAction {
	private IUserManageService userManageService;
	public String execute() throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map=userManageService.Ratio_ReturnedWoker();
		map.put("status", "success");
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
		return null;
	}
	public IUserManageService getUserManageService() {
		return userManageService;
	}
	public void setUserManageService(IUserManageService userManageService) {
		this.userManageService = userManageService;
	}
	
}

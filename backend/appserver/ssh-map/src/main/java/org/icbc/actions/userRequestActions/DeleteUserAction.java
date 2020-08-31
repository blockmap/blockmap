package org.icbc.actions.userRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IUserManageService;
import org.icbc.dataAccess.dto.UserDto;
import org.icbc.tool.ResultUtils;

public class DeleteUserAction {
	private long id;
	private IUserManageService userManageService;
	public String execute() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		UserDto user = userManageService.getUser(id);
		if(user.getId()==-1) {
			map.put("status", "No such User!");
		}else {
			userManageService.deleteUser(user);
			map.put("status", "success");
		}		
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
    	return null;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public IUserManageService getUserManageService() {
		return userManageService;
	}
	public void setUserManageService(IUserManageService userManageService) {
		this.userManageService = userManageService;
	}
}

package org.icbc.actions.userRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IUserManageService;
import org.icbc.dataAccess.dto.UserDto;
import org.icbc.tool.ResultUtils;

public class LoginUserAction {
	private String username;
    private String password;
    private IUserManageService userManageService;
    //private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginUserAction.class);
    public String execute() throws IOException {
    	/*try {*/
    	Map<String, Object> map = new HashMap<String, Object>();
    	UserDto user = new UserDto();
    	user = userManageService.findUserByNameAndPassword(username, password);
    	if(user.getId()==null) {
    		map.put("status", "UserName or password is Wrong");
    	}else {
    		map.put("id", user.getId());
    		map.put("username", username);
    		map.put("Imageurl", user.getImgurl());
    		map.put("Type", user.getType());
    		map.put("status", "success");
    	}
    	/*UserDto user = new UserDto();
    	map.put("status", "success");
    	long id = userManageService.findUserByNameAndPassword(username, password);
    	if(id!=-1) {
    		user = userManageService.getUser(id);
    		map.put("username", username);
    		map.put("Imageurl", user.getImgurl());
    		map.put("status", "success");
    	}else {
    		map.put("status", "UserName or password is Wrong");
    	}*/
    	/*PropertyConfigurator.configure("log4j.properties");
    	Logger log = Logger.getLogger(LoginUserAction.class);
    	log.debug("LoginAction");*/
    	ResultUtils.toJson(ServletActionContext.getResponse(), map);
    	/*}catch(Exception e) {
    		logger.error(e.getMessage());
    	}*/
    	return null;
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public IUserManageService getUserManageService() {
		return userManageService;
	}
	public void setUserManageService(IUserManageService userManageService) {
		this.userManageService = userManageService;
	}
    
}

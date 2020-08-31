package org.icbc.actions.institutionRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IInstitutionService;
import org.icbc.tool.ResultUtils;

public class ReturnableCompanyAction {
	Map<String,Object> map = new HashMap<>();
	private IInstitutionService institutionService;
	public String execute() throws IOException {
		map = institutionService.ReturnableCompany();
		/*for(Map.Entry<String,Integer> entry : map.entrySet()){  
		    System.out.print("Key = "+entry.getKey()+",value="+entry.getValue());  
		}*/  
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

	public IInstitutionService getInstitutionService() {
		return institutionService;
	}
	public void setInstitutionService(IInstitutionService institutionService) {
		this.institutionService = institutionService;
	}
	
}

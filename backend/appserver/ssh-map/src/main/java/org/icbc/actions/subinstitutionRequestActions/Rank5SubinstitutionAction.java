package org.icbc.actions.subinstitutionRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.ISubinstitutionService;
import org.icbc.tool.ResultUtils;

public class Rank5SubinstitutionAction {
	private List<String> subinstitutions;
	private ISubinstitutionService subinstitutionService;
	public String execute() throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String sub = null;
		String recom ;
		subinstitutions = subinstitutionService.rank5Subinstitution();		
		if(subinstitutions == null || subinstitutions.size() ==0) {
			map.put("status", "Subinstitutions are null!");
		}
		else {
			Map<String,Object>[]maps=new HashMap[subinstitutions.size()];
    		for(int i=0;i<subinstitutions.size();i++) {
    			maps[i]=new HashMap<>();
    		}
			for (int i=0;i<5;i++) {
				sub = subinstitutions.get(i);
				recom = String.format("%.2f", Math.random()*0.5+(9.5-0.5*i));
				maps[i].put("branch", sub);
				maps[i].put("recom", recom);
			}
			map.put("data", maps);
			map.put("status", "success");
		}
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
		return null;
	}
	
	public List<String> getSubinstitutions() {
		return subinstitutions;
	}

	public void setSubinstitutions(List<String> subinstitutions) {
		this.subinstitutions = subinstitutions;
	}

	public ISubinstitutionService getSubinstitutionService() {
		return subinstitutionService;
	}
	public void setSubinstitutionService(ISubinstitutionService subinstitutionService) {
		this.subinstitutionService = subinstitutionService;
	}
	
}

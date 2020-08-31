package org.icbc.actions.subinstitutionRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.ISubinstitutionService;
import org.icbc.dataAccess.dto.SubinstitutionDto;
import org.icbc.tool.ResultUtils;

public class FindWorkSubinstitutionAction {
	private int page;
	private int limit;
	private List<SubinstitutionDto> subinstitutions;
	private ISubinstitutionService subinstitutionService;
	public String execute() throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> mapsta = new HashMap<String, String>();
		subinstitutions = subinstitutionService.selectWorkSubinstitution(page, limit);	
		System.out.println(subinstitutions.size());
		if(subinstitutions == null || subinstitutions.size() ==0) {
			mapsta.put("status","fail");
			ResultUtils.toJson(ServletActionContext.getResponse(), mapsta);
			return null;
		}
		else {
			map.put("subinstitution", subinstitutions);
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
			return null;
		}
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
	public List<SubinstitutionDto> getSubinstitutions() {
		return subinstitutions;
	}
	public void setSubinstitutions(List<SubinstitutionDto> subinstitutions) {
		this.subinstitutions = subinstitutions;
	}
	public ISubinstitutionService getSubinstitutionService() {
		return subinstitutionService;
	}
	public void setSubinstitutionService(ISubinstitutionService subinstitutionService) {
		this.subinstitutionService = subinstitutionService;
	}
	
}

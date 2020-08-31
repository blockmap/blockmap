package org.icbc.actions.institutionRequestActions;

import org.icbc.bussinessService.IInstitutionService;
import org.icbc.dataAccess.dto.InstitutionDto;

public class UpdateInstitutionAction {
	private long id;
	private int isreturnable;
	private IInstitutionService institutionService;
	public String execute() {
		InstitutionDto ins = institutionService.getById(id);
		if(ins==null) {
			return "fail";
		}else {
			ins.setIsreturnable(isreturnable);
			institutionService.UpdateInstitution(ins);
			return "success";
		}
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIsreturnable() {
		return isreturnable;
	}
	public void setIsreturnable(int isreturnable) {
		this.isreturnable = isreturnable;
	}
	public IInstitutionService getInstitutionService() {
		return institutionService;
	}
	public void setInstitutionService(IInstitutionService institutionService) {
		this.institutionService = institutionService;
	}
	
}

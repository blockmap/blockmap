package org.icbc.actions.institutionRequestActions;

import org.icbc.bussinessService.IInstitutionService;
import org.icbc.dataAccess.dto.InstitutionDto;

public class AddInstitutionAction {
    private String institutionname;  
    private String profession;  
    private int isreturnable;
    private IInstitutionService institutionService;
    public String execute() {
    	InstitutionDto ins = new InstitutionDto();
    	ins.setInstitutionname(institutionname);
    	ins.setProfession(profession);
    	ins.setIsreturnable(isreturnable);
    	institutionService.addNewInstitution(ins);
    	return "success";
    }
	public String getInstitutionname() {
		return institutionname;
	}
	public void setInstitutionname(String institutionname) {
		this.institutionname = institutionname;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
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

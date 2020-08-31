package org.icbc.dataAccess.dto;
//总机构表
public class InstitutionDto {
	private Long id;
    private String institutionname;  //机构名称
    private String profession;  //所属行业
    private int isreturnable; //是否复工---0：未复工，1：已复工
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
    
    
}

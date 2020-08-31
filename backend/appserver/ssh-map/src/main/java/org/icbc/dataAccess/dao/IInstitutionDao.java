package org.icbc.dataAccess.dao;

import java.util.Map;

import org.icbc.dataAccess.dto.InstitutionDto;

public interface IInstitutionDao {
	public void addNewInstitution(InstitutionDto ins);
	public void UpdateInstitution(InstitutionDto ins);
	public void DeleteInstitution(InstitutionDto ins);
	InstitutionDto getById(Long id);
	//各行业可复工公司数目
	Map<String,Object> ReturnableCompany();
}

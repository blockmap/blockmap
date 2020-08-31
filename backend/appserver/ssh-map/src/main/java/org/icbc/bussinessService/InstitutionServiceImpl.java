package org.icbc.bussinessService;

import java.util.Map;

import org.icbc.dataAccess.dao.IInstitutionDao;
import org.icbc.dataAccess.dto.InstitutionDto;

public class InstitutionServiceImpl implements IInstitutionService{
	private IInstitutionDao institutionDao;
	@Override
	public void addNewInstitution(InstitutionDto ins) {
		// TODO Auto-generated method stub
		institutionDao.addNewInstitution(ins);
	}

	@Override
	public void UpdateInstitution(InstitutionDto ins) {
		// TODO Auto-generated method stub
		institutionDao.UpdateInstitution(ins);
	}

	@Override
	public void DeleteInstitution(InstitutionDto ins) {
		// TODO Auto-generated method stub
		institutionDao.DeleteInstitution(ins);
	}

	@Override
	public InstitutionDto getById(Long id) {
		// TODO Auto-generated method stub
		return institutionDao.getById(id);
	}

	@Override
	public Map<String, Object> ReturnableCompany() {
		// TODO Auto-generated method stub
		return institutionDao.ReturnableCompany();
	}

	public IInstitutionDao getInstitutionDao() {
		return institutionDao;
	}

	public void setInstitutionDao(IInstitutionDao institutionDao) {
		this.institutionDao = institutionDao;
	}
	
	
}

package org.icbc.bussinessService;

import java.util.List;
import java.util.Map;

import org.icbc.dataAccess.dao.ISubinstitutionDao;
import org.icbc.dataAccess.dto.SubinstitutionDto;

public class SubinstitutionServiceImpl implements ISubinstitutionService{
	private ISubinstitutionDao subinstitutionDao;
	@Override
	public void addNewSubinstitution(SubinstitutionDto subinstitution) {
		// TODO Auto-generated method stub
		subinstitutionDao.save(subinstitution);
	}

	@Override
	public void deleteSubinstitution(long id) {
		// TODO Auto-generated method stub
		subinstitutionDao.delete(id);
	}

	@Override
	public void updateSubinstitution(SubinstitutionDto subinstitution) {
		// TODO Auto-generated method stub
		subinstitutionDao.update(subinstitution);
	}

	@Override
	public SubinstitutionDto getSubinstitution(long id) {
		// TODO Auto-generated method stub
		System.out.println("ok"+id);
		return subinstitutionDao.getById(id);
	}

	@Override
	public List<SubinstitutionDto> selectWorkSubinstitution(int page, int limit) {
		// TODO Auto-generated method stub
		int offset=(page-1)*limit;
		return subinstitutionDao.selectWorkSubinstitution(offset, limit);
	}

	@Override
	public List<String> rank5Subinstitution() {
		// TODO Auto-generated method stub
		return subinstitutionDao.rank5Subinstitution();
	}
	
	@Override
	public Map<String, Object> ReturnableWorker() {
		// TODO Auto-generated method stub
		return subinstitutionDao.ReturnableWorker();
	}
	
	@Override
	public Map<String, Object> RegionalPedestrianflow() {
		// TODO Auto-generated method stub
		return subinstitutionDao.RegionalPedestrianflow();
	}
	
	public ISubinstitutionDao getSubinstitutionDao() {
		return subinstitutionDao;
	}

	public void setSubinstitutionDao(ISubinstitutionDao subinstitutionDao) {
		this.subinstitutionDao = subinstitutionDao;
	}

	@Override
	public Map<String,Object> AllSubinstitution() {
		// TODO Auto-generated method stub
		return subinstitutionDao.AllSubinstitution();
	}

	@Override
	public Map<String, Object> getSubinstitutionwithPage(int page, int limit) {
		// TODO Auto-generated method stub
		return subinstitutionDao.getSubinstitutionwithPage(page, limit);
	}

	
	
}

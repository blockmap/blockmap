package org.icbc.bussinessService;

import java.util.Map;

import org.icbc.dataAccess.dao.IConfirmInformationPostDao;
import org.icbc.dataAccess.dto.ConfirmInformationPostDto;

public class ConfirmInformationServiceImpl implements IConfirmInformationService{
	private IConfirmInformationPostDao confirmDao;
	@Override
	public void addNewConfirm(ConfirmInformationPostDto confirm,long id,int status) {
		// TODO Auto-generated method stub
		confirmDao.save(confirm,id,status);
	}

	@Override
	public void deleteConfirm(ConfirmInformationPostDto confirm) {
		// TODO Auto-generated method stub
		confirmDao.delete(confirm);
	}

	@Override
	public void updateConfirm(ConfirmInformationPostDto confirm) {
		// TODO Auto-generated method stub
		confirmDao.update(confirm);
	}

	@Override
	public ConfirmInformationPostDto getConfirm(long id) {
		// TODO Auto-generated method stub
		return confirmDao.getById(id);
	}

	public IConfirmInformationPostDao getConfirmDao() {
		return confirmDao;
	}

	public void setConfirmDao(IConfirmInformationPostDao confirmDao) {
		this.confirmDao = confirmDao;
	}

	@Override
	public void updatestate(long id) {
		// TODO Auto-generated method stub
		confirmDao.updatestate(id);
	}

	@Override
	public Map<String, Object> getComfirmPostwithPage(int page, int limit) {
		// TODO Auto-generated method stub
		return confirmDao.getComfirmPostwithPage(page, limit);
	}
	
}

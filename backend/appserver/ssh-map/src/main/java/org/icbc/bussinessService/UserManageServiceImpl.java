package org.icbc.bussinessService;

import java.util.Map;

import org.icbc.dataAccess.dao.IUserDao;
import org.icbc.dataAccess.dto.UserDto;

public class UserManageServiceImpl implements IUserManageService{
	private IUserDao userDao;
	public void addNewUser(UserDto user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	public void deleteUser(UserDto user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	public void updateUser(UserDto user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	public UserDto getUser(long id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}

	@Override
	public Map<String, Object> RegionalInfection_Suspected() {
		// TODO Auto-generated method stub
		return userDao.RegionalInfection_Suspected();
	}
	
	@Override
	public UserDto findUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return userDao.findUserByNameAndPassword(name, password);
	}
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Map<String, Object> getUserwithPage(int page, int limit) {
		// TODO Auto-generated method stub
		return userDao.getUserwithPage(page, limit);
	}

	@Override
	public Map<String, Object> Ratio_ReturnedWoker() {
		// TODO Auto-generated method stub
		return userDao.Ratio_ReturnedWoker();
	}

	@Override
	public Map<String, Object> Ratio_Fever(String id) {
		// TODO Auto-generated method stub
		return userDao.Ratio_Fever(id);
	}

		
}

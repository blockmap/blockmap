package org.icbc.bussinessService;

import java.util.Map;

import org.icbc.dataAccess.dto.UserDto;

public interface IUserManageService {
		//增加新用户
		public void addNewUser(UserDto user);
		//删除现有用户
		public void deleteUser(UserDto user);
		//更新现有用户
		public void updateUser(UserDto user);
		//根据id值查询用户
		public UserDto getUser(long id); 
		//用户登录
		public UserDto findUserByNameAndPassword(String name, String password);
		//区域感染/疑似数
		Map<String,Object> RegionalInfection_Suspected();
		//分页展示员工情况
		public Map<String,Object> getUserwithPage(int page,int limit);
		//复工比例
		public Map<String,Object> Ratio_ReturnedWoker();
		//发热比例
		public Map<String,Object> Ratio_Fever(String id);
}

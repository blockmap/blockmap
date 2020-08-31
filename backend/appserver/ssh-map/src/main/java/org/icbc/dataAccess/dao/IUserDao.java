package org.icbc.dataAccess.dao;

import java.util.Map;

import org.icbc.dataAccess.dto.UserDto;
//对User数据表的CRUD
public interface IUserDao {
		//根据id值查询用户信息
		UserDto getById(Long id);
		//删除用户信息
		void delete(UserDto user);
		//保存用户信息
		void save(UserDto user);
		//更新用户信息
		void update(UserDto user);
		//新增或更新用户信息
		void saveOrUpdate(UserDto user);
		//用户的登录操作
		UserDto findUserByNameAndPassword(String name, String password);
		//区域感染/疑似数
		Map<String,Object> RegionalInfection_Suspected();
		//分页展示员工情况
		Map<String,Object> getUserwithPage(int page,int limit);
		//复工比例
		Map<String,Object> Ratio_ReturnedWoker();
		//发热比例
		Map<String,Object> Ratio_Fever(String id);
}

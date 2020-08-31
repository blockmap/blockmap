package org.icbc.dataAccess.dao;

import java.util.List;
import java.util.Map;

import org.icbc.dataAccess.dto.SubinstitutionDto;


public interface ISubinstitutionDao {
	//根据id值查询机构信息
	SubinstitutionDto getById(Long id);
	//删除机构信息
	void delete(long id);
	//保存机构信息
	void save(SubinstitutionDto subinstitution);
	//更新机构信息
	void update(SubinstitutionDto subinstitution);
	//新增或更新机构信息
	void saveOrUpdate(SubinstitutionDto subinstitution);
	//查找可复工的机构
	List<SubinstitutionDto> selectWorkSubinstitution(int offset, int limit);  
	//复工网点rank
	List<String> rank5Subinstitution();
	//各公司可复工人数
	Map<String,Object> ReturnableWorker();
	//分店所在区域人流量统计
	Map<String,Object> RegionalPedestrianflow();
	//获取部门列表
	Map<String,Object> AllSubinstitution();
	//分页展示部门情况
	Map<String,Object> getSubinstitutionwithPage(int page,int limit);
}

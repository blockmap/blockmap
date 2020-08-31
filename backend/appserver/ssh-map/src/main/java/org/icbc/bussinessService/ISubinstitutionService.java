package org.icbc.bussinessService;

import java.util.List;
import java.util.Map;

import org.icbc.dataAccess.dto.SubinstitutionDto;

public interface ISubinstitutionService {
		//增加机构信息
		public void addNewSubinstitution(SubinstitutionDto subinstitution);
		//删除机构信息
		public void deleteSubinstitution(long id);
		//更新机构信息
		public void updateSubinstitution(SubinstitutionDto subinstitution);
		//根据id值查询机构信息
		public SubinstitutionDto getSubinstitution(long id);
		//查询机构复工情况
		public List<SubinstitutionDto> selectWorkSubinstitution(int page, int limit);
		//推荐复工网点rank
		public List<String> rank5Subinstitution();
		//各公司可复工人数
		public Map<String,Object> ReturnableWorker();
		//分店所在区域人流量统计
		public Map<String,Object> RegionalPedestrianflow();
		//获取部门列表
		public Map<String,Object> AllSubinstitution();
		//分页展示部门情况
		public Map<String,Object> getSubinstitutionwithPage(int page,int limit);
}

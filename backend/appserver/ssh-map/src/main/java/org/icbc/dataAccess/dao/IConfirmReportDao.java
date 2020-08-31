package org.icbc.dataAccess.dao;

import java.util.Map;

import org.icbc.dataAccess.dto.ConfirmReportDto;

public interface IConfirmReportDao {
	//分页展示疫情上报表情况
	Map<String,Object> getConfirmReportwithPage(int page,int limit);
	//删除疫情上报表信息
	void delete(long id);
	//保存疫情上报表信息
	void save(ConfirmReportDto confirmreport);
}

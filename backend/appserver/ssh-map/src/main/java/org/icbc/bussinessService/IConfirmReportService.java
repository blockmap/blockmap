package org.icbc.bussinessService;

import java.util.Map;

import org.icbc.dataAccess.dto.ConfirmReportDto;

public interface IConfirmReportService {
	//分页展示疫情上报表情况
	public Map<String,Object> getConfirmReportwithPage(int page,int limit);
	//删除疫情上报表信息
	public void delete(long id);
	//保存疫情上报表信息
	public void save(ConfirmReportDto confirmreport);
}

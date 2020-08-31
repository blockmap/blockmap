package org.icbc.bussinessService;

import java.util.Map;

import org.icbc.dataAccess.dto.ConfirmInformationPostDto;

public interface IConfirmInformationService {
	//增加确诊信息
	public void addNewConfirm(ConfirmInformationPostDto confirm,long id,int status);
	//删除确诊信息
	public void deleteConfirm(ConfirmInformationPostDto confirm);
	//更新确诊信息
	public void updateConfirm(ConfirmInformationPostDto confirm);
	//根据id值查询确诊信息
	public ConfirmInformationPostDto getConfirm(long id);
	//更改申报状态
	public void updatestate(long id);
	//分页展示疫情上报情况
	public Map<String,Object> getComfirmPostwithPage(int page,int limit);
}

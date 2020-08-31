package org.icbc.actions.confirmreportRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IConfirmReportService;
import org.icbc.dataAccess.dto.ConfirmReportDto;
import org.icbc.tool.ResultUtils;

public class AddReportAction {
	private String name;
	private String confirmed;
	private String date;
	private String symptoms;
	private IConfirmReportService reportService;
	public String execute() throws IOException {
    	Map<String, String> map = new HashMap<String, String>();
    	ConfirmReportDto report = new ConfirmReportDto();
    	try {
    	if(name.trim()==""||confirmed.trim()==""||date.trim()==""||symptoms.trim()=="") {
    		map.put("status", "Important Keys are NULL!");
    	}else {
    		report.setName(name);
    		report.setConfirmed(confirmed);
    		report.setDate(date);
    		report.setSymptoms(symptoms);
    		reportService.save(report);
    		map.put("status", "success");
    	}
    	}catch(Exception e) {
    		map.put("status", "fail");
    	}
    	ResultUtils.toJson(ServletActionContext.getResponse(), map);
    	return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public IConfirmReportService getReportService() {
		return reportService;
	}
	public void setReportService(IConfirmReportService reportService) {
		this.reportService = reportService;
	}
	
}

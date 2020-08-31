package org.icbc.actions.confirmreportRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IConfirmReportService;
import org.icbc.tool.ResultUtils;

public class DeleteReportAction {
	private long id;
	private IConfirmReportService reportService;
	public String execute() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		reportService.delete(id);
		map.put("status", "success");
		ResultUtils.toJson(ServletActionContext.getResponse(), map);
    	return null;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public IConfirmReportService getReportService() {
		return reportService;
	}
	public void setReportService(IConfirmReportService reportService) {
		this.reportService = reportService;
	}
	
}

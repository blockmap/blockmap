package org.icbc.actions.confirmreportRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IConfirmReportService;
import org.icbc.tool.ResultUtils;

public class GetReportwithPageAction {
	private int page;
    private int limit;
    private IConfirmReportService reportService;
    public String execute() throws IOException {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map=reportService.getConfirmReportwithPage(page, limit);
    	map.put("status", "success");
    	ResultUtils.toJson(ServletActionContext.getResponse(), map);
    	return null;
    }
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public IConfirmReportService getReportService() {
		return reportService;
	}
	public void setReportService(IConfirmReportService reportService) {
		this.reportService = reportService;
	}
    
}

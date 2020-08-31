package org.icbc.actions.confirmRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.icbc.bussinessService.IConfirmInformationService;

public class GetPostwithPageAction {
	private int page;
    private int limit;
    private IConfirmInformationService confirmService;
    public String execute() throws IOException {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map=confirmService.getComfirmPostwithPage(page, limit);
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
	public IConfirmInformationService getConfirmService() {
		return confirmService;
	}
	public void setConfirmService(IConfirmInformationService confirmService) {
		this.confirmService = confirmService;
	}
    
}

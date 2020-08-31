package org.icbc.bussinessService;

import java.util.Map;

import org.icbc.dataAccess.dao.IConfirmReportDao;
import org.icbc.dataAccess.dto.ConfirmReportDto;

public class ConfirmReportServiceImpl implements IConfirmReportService{
	private IConfirmReportDao reportdao;
	@Override
	public Map<String, Object> getConfirmReportwithPage(int page, int limit) {
		// TODO Auto-generated method stub
		return reportdao.getConfirmReportwithPage(page, limit);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		reportdao.delete(id);
	}

	@Override
	public void save(ConfirmReportDto confirmreport) {
		// TODO Auto-generated method stub
		reportdao.save(confirmreport);
	}

	public IConfirmReportDao getReportdao() {
		return reportdao;
	}

	public void setReportdao(IConfirmReportDao reportdao) {
		this.reportdao = reportdao;
	}
	

}

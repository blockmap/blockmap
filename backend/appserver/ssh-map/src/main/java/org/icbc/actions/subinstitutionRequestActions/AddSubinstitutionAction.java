package org.icbc.actions.subinstitutionRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.ISubinstitutionService;
import org.icbc.dataAccess.dto.SubinstitutionDto;
import org.icbc.tool.ResultUtils;

public class AddSubinstitutionAction {
	private String subinstitutionname;
    private String institutionId;
    private String profession;
    private String tel;
    private String province;
    private String city;
    private String district;
    private String street; 
    private String detailAddress;
    private float lon;//¾­¶È
    private float lat;//Î³¶È
    private double riskLevel;
    private Long passengerFlow;
    private ISubinstitutionService subinstitutionService;
    public String execute() throws IOException {
    	Map<String, String> map = new HashMap<String, String>();
    	try {
    	if(subinstitutionname.trim()==""||tel.trim()==""||institutionId.trim()==""||district.trim()==""||detailAddress.trim()==""||riskLevel+"".trim()==null||passengerFlow+"".trim()=="") {
    		map.put("status", "Important Keys are null!");
    	}
    	else {
    		SubinstitutionDto subinstitutionDto = new SubinstitutionDto();
        	subinstitutionDto.setSubinstitutionname(subinstitutionname);
        	subinstitutionDto.setInstitutionId(institutionId);
        	subinstitutionDto.setProfession(profession);
        	subinstitutionDto.setTel(tel);
        	subinstitutionDto.setProvince(province);
        	subinstitutionDto.setCity(city);
        	subinstitutionDto.setDistrict(district);
        	subinstitutionDto.setStreet(street);
        	subinstitutionDto.setDetailAddress(detailAddress);
        	subinstitutionDto.setLon(lon);
        	subinstitutionDto.setLat(lat);
        	subinstitutionDto.setRiskLevel(riskLevel);
        	subinstitutionDto.setPassengerFlow(passengerFlow);
        	subinstitutionService.addNewSubinstitution(subinstitutionDto);
        	map.put("status", "success");
    	} 
    	}catch(Exception e) {
    		map.put("status", "fail");
    	}
    	ResultUtils.toJson(ServletActionContext.getResponse(), map);
		return null;
    }

	public String getSubinstitutionname() {
		return subinstitutionname;
	}
	public void setSubinstitutionname(String subinstitutionname) {
		this.subinstitutionname = subinstitutionname;
	}
	
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public double getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(double riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Long getPassengerFlow() {
		return passengerFlow;
	}

	public void setPassengerFlow(Long passengerFlow) {
		this.passengerFlow = passengerFlow;
	}

	public ISubinstitutionService getSubinstitutionService() {
		return subinstitutionService;
	}
	public void setSubinstitutionService(ISubinstitutionService subinstitutionService) {
		this.subinstitutionService = subinstitutionService;
	}
    
}

package org.icbc.dataAccess.dto;

public class SubinstitutionDto {
	private Long id;
    private String subinstitutionname;
    private String institutionId;  //所属机构
    private String profession;   //所属行业
    private String tel;
    private String province;
    private String city;
    private String district; //区
    private String street;  //街道
    private String detailAddress;  //详细地址
    private float lon;//经度
    private float lat;//纬度
    private double riskLevel;  //风险等级
    private Long passengerFlow;//客流量
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
    
    
}

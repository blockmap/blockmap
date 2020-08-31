package org.icbc.actions.userRequestActions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IUserManageService;
import org.icbc.dataAccess.dto.UserDto;
import org.icbc.tool.ResultUtils;

public class UpdateUserAction {
	private long id;
	private String username;
    private String password;
    private String realname;
    private String identity;
    private String email;
    private String phone; 
    private String institutionid;
    private String subinstitutionid;       
    private int type;    
    private String gender;  
    private int age;
    private int status;
    private String country;
    private String province;
    private String city;
    private String district; 
    private String address;  
    private float lon;   
    private float lat;
    private String imgurl;
	private IUserManageService userManageService;
	public String execute() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		UserDto user = new UserDto();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setRealname(realname);
		user.setIdentity(identity);
		user.setEmail(email);
		user.setPhone(phone);
		user.setInstitutionid(institutionid);
		user.setSubinstitutionid(subinstitutionid);
		user.setType(type);
		user.setGender(gender);
		user.setAge(age);
		user.setStatus(status);
		user.setCountry(country);
		user.setProvince(province);
		user.setCity(city);
		user.setDistrict(district);
		user.setAddress(address);
		user.setLon(lon);
		user.setLat(lat);
		user.setImgurl(imgurl);
		userManageService.updateUser(user);
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getInstitutionid() {
		return institutionid;
	}
	public void setInstitutionid(String institutionid) {
		this.institutionid = institutionid;
	}
	
	public String getSubinstitutionid() {
		return subinstitutionid;
	}
	public void setSubinstitutionid(String subinstitutionid) {
		this.subinstitutionid = subinstitutionid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public IUserManageService getUserManageService() {
		return userManageService;
	}
	public void setUserManageService(IUserManageService userManageService) {
		this.userManageService = userManageService;
	}
	
}

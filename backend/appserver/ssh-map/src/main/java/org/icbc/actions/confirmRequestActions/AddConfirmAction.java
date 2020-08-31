package org.icbc.actions.confirmRequestActions;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.bussinessService.IConfirmInformationService;
import org.icbc.dataAccess.dto.ConfirmInformationPostDto;
import org.icbc.tool.ResultUtils;

public class AddConfirmAction {
	private long id;
	private int status;
	private String username;
	private String branch;
    private String gender;
    private int age;
    private String email;
    private String phone;   
    private String province;
    private String city;
    private String district; 
    private String detailAddress;
    private String confirmDate;
    private String pathPost;
    private String description;
    private String state;
    private IConfirmInformationService confirmService;
    public String execute() throws IOException {
    	Map<String, String> map = new HashMap<String, String>();
    	ConfirmInformationPostDto confirm = new ConfirmInformationPostDto();
    	long user_id = id;
    	try {
    		if(detailAddress.trim()=="" || confirmDate.trim()=="" || pathPost.trim()=="") {
    			map.put("status", "fail");
    		}else {
    			confirm.setUsername(username);
    			confirm.setBranch(branch);
    			confirm.setGender(gender);
    			confirm.setAge(age);
    			confirm.setEmail(email);
    			confirm.setPhone(phone);
    			confirm.setProvince(province);
    			confirm.setCity(city);
    			confirm.setDistrict(district);
    			confirm.setDetailAddress(detailAddress);
    			confirm.setConfirmDate(confirmDate);
    			confirm.setPathPost(pathPost);
    			confirm.setDescription(description);
    			confirm.setState(state);
    			confirmService.addNewConfirm(confirm,user_id,status);
    			map.put("status", "success");
    		}	
    	}catch(Exception e) {
    		map.put("status", "fail");
    	}
    	ResultUtils.toJson(ServletActionContext.getResponse(), map);
    	return null;
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}
	public String getPathPost() {
		return pathPost;
	}
	public void setPathPost(String pathPost) {
		this.pathPost = pathPost;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public IConfirmInformationService getConfirmService() {
		return confirmService;
	}
	public void setConfirmService(IConfirmInformationService confirmService) {
		this.confirmService = confirmService;
	}
    
}

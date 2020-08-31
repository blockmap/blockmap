package org.icbc.dataAccess.dto;


//记录用户个人信息
public class UserDto {
	private Long id;
    private String username;//非空
    private String password;//非空
    private String realname; //真实姓名//非空
    private String identity; //身份证号//非空
    private String email;
    private String phone;   //联系方式
    private String institutionid;       //用户所属总结构 非空
    private String subinstitutionid;       //用户所属子机构，外键 非空
    private int type;    //0管理员，1普通用户 非空
    private String gender;  //0女，1男
    private int age;
    private int status;   //0确诊，1疑似，2健康 非空
    private String country;
    private String province;
    private String city;
    private String district; //区 非空
    private String address;
    private float lon;   //家庭地址经度
    private float lat;  //家庭地址纬度
    private String imgurl;   //图像路径 非空
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getInstitutionid() {
		return institutionid;
	}
	public void setInstitutionid(String institutionid) {
		this.institutionid = institutionid;
	}
	
	
    
}

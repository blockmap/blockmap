<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
</head>
<body>
	用户注册:<br>
	<form action="register">
		Name:<input type="text" name="username">
		Password:<input type="text" name="password">
		Realname:<input type="text" name="realname">
		<button type="submit">Register</button>
	</form><br>
	用户登录:<br>
	<form action="login">
		Name:<input type="text" name="username">
		Password:<input type="text" name="password">
		<button type="submit">Login</button>
	</form><br>
	更新疫情申报状态:<br>
	<form action="updatestate">
		ID:<input type="text" name="id">
		<button type="submit">Updatestate</button> <!-- 更新疫情上报申报状态 未设置id不存在的情况 -->
	</form><br>
	分页展示疫情上报信息:<br>
	<form action="getpostwithpage">
		Page:<input type="text" name="page">
		Limit:<input type="text" name="limit">
		<button type="submit">Getpostwithpage</button>
	</form> <!-- 分页展示疫情上报信息 --><br>
	疫情上报:<br>
	<form action="post">
		ID:<input type="text" name="id">
		ConfirmDate:<input type="text" name="confirmDate">
		PathPost:<input type="text" name="pathPost">
		DetailAddress:<input type="text" name="detailAddress">
		<button type="submit">PostConfirm</button> <!-- 疫情上报 -->
	</form><br>
	增加部门信息:<br>
	<form action="addsubinstitution">
		Subinstitutionname:<input type="text" name="subinstitutionname">
		Profession:<input type="text" name="profession">
		tel:<input type="text" name="tel">
		institutionId:<input type="text" name="institutionId">
		district:<input type="text" name="district">
		detailAddress:<input type="text" name="detailAddress">
		riskLevel:<input type="text" name="riskLevel">
		passengerFlow:<input type="text" name="passengerFlow">
		<button type="submit">Addsubinstitution</button>
	</form><br> <!-- 增加部门信息  必要字段非空否则报错-->
	删除部门信息:<br>
	<form action="deletesubinstitution">
		Delete-id:<input type="text" name="id">
		<button type="submit">deletesubinstitution</button>
	</form><br> <!-- 删除部门信息 没有设置id为空的情况-->
	查询用户信息:<br>
	<form action="query">
		Query-id:<input type="text" name="id">
		<button type="submit">query</button>
	</form><br> <!-- 查询用户信息 -->
	更新用户信息:<br>
	<form action="update">
		ID:<input type="text" name="id">
		Lon:<input type="text" name="lon">
		Lat:<input type="text" name="lat">
		<button type="submit">UpdateUser</button>
	</form><br> <!-- 更新用户信息 -->
	删除用户:<br>
	<form action="delete">
		ID:<input type="text" name="id">
		<button type="submit">DeleteUser</button>
	</form><br> <!-- 删除用户 -->
	分页展示员工信息:<br>
	<form action="getuserwithpage">
		Page:<input type="text" name="page">
		Limit:<input type="text" name="limit">
		<button type="submit">Getuserwithpage</button>
	</form><br> <!-- 分页展示员工信息 -->
	分页展示部门信息<br>
	<form action="getsubwithpage">
		Page:<input type="text" name="page">
		Limit:<input type="text" name="limit">
		<button type="submit">Getsubwithpage</button>
	</form><br> <!-- 分页展示部门信息 -->
	分页展示上报记录信息<br>
	<form action="getreportwithpage">
		Page:<input type="text" name="page">
		Limit:<input type="text" name="limit">
		<button type="submit">Getreportwithpage</button>
	</form><br> <!-- 分页展示上报记录信息 -->
	添加上报记录信息:<br>
	<form action="report">
		Name:<input type="text" name="name">
		Confirmed:<input type="text" name="confirmed">
		Date:<input type="text" name="date">
		Symptoms:<input type="text" name="symptoms">
		<button type="submit">ReportMessage</button> <!-- 添加上报记录信息 -->
	</form><br>
	删除上报记录信息:<br>
	<form action="deletereport">
		ID:<input type="text" name="id">
		<button type="submit">Deletereport</button>
	</form><br> <!-- 删除上报记录信息 -->
	推荐前5的复工部门:<a href="rank5subinstitution">top5</a><br> <!-- 推荐前5的复工部门 -->
	区域确诊-疑似数目:<a href="regionalinfection_suspected">regionalinfection_suspected</a><br> <!-- 区域确诊-疑似数目 -->
	区域客流量:<a href="regionalpedestrianflow">regionalpedestrianflow</a><br> <!-- 区域客流量 -->
	公司复工人数:<a href="returnableworker">returnableworker</a><br> <!-- 公司复工人数 -->
	所有部门:<a href="allsubinstitution">Allsubinstitution</a><br> <!-- 所有部门 -->
	复工行业比较:<a href="returnablecompany">returnablecompany</a><br> <!-- 复工行业比较 -->
	复工比例:<a href="ratio_returnedworker">Ratio_returnedworker</a><br> <!-- 复工比例 -->
	发热比例:
	<form action="ratio_fever">
		Branch-id:<input type="text" name="id">
		<button type="submit">Ratio_fever</button>
	</form><br> <!-- 发热比例 -->
	
	
	
	<!--<a href="findworksubinstitution">findworksubinstitution</a> -->
</body>
</html>
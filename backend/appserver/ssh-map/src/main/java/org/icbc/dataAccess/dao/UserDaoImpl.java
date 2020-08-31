package org.icbc.dataAccess.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.icbc.dataAccess.dto.UserDto;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao{

	public boolean testHibernateTemplate(){
        if(getHibernateTemplate() == null)return false;
        return true;
    }

	public UserDto getById(Long id) {
		// TODO Auto-generated method stub
		//return (UserDto) getHibernateTemplate().get(UserDto.class, id);
		UserDto userdto = new UserDto();
		String driver = "com.mysql.jdbc.Driver";
    	// URL指向要访问的数据库名test1
    	String url = "jdbc:mysql://10.2.1.204:3306/intern";
    	// MySQL配置时的用户名
    	String user = "root";
    	// Java连接MySQL配置时的密码
    	String p_word = "123456";
    	try {
    		// 1 加载驱动程序
    		Class.forName(driver);
    		// 2 连接数据库
    		Connection conn = (Connection) DriverManager.getConnection(url, user, p_word);
    		// 3 用来执行SQL语句
    		Statement statement = (Statement) conn.createStatement();
    		// 要执行的SQL语句
    		String sql = "select * from user where id = '"+id+"'";
    		ResultSet rs = statement.executeQuery(sql);
    		if(rs.first()) {
    			rs.previous();
    			while(rs.next()) {
        			userdto.setId(rs.getLong("id"));
        			userdto.setUsername(rs.getString("username"));
        			userdto.setPassword(rs.getString("password"));
        			userdto.setRealname(rs.getString("realname"));
        			userdto.setIdentity(rs.getString("identity"));
        			userdto.setEmail(rs.getString("email"));
        			userdto.setPhone(rs.getString("phone"));
        			userdto.setInstitutionid(rs.getString("institutionid"));
        			userdto.setSubinstitutionid(rs.getString("subinstitutionid"));
        			userdto.setType(rs.getInt("type"));
        			userdto.setGender(rs.getString("gender"));
        			userdto.setAge(rs.getInt("age"));
        			userdto.setStatus(rs.getInt("status"));
        			userdto.setCountry(rs.getString("country"));
        			userdto.setProvince(rs.getString("province"));
        			userdto.setCity(rs.getString("city"));
        			userdto.setDistrict(rs.getString("district"));
        			userdto.setAddress(rs.getString("address"));
        			userdto.setLon(rs.getFloat("lon"));
        			userdto.setLat(rs.getFloat("lat"));
        			userdto.setImgurl(rs.getString("imgurl"));
        		}
    		}else {
    			userdto.setId((long) -1);
    		}	
    		rs.close();
    		conn.close();
    	} catch (ClassNotFoundException e) {
    		System.out.println("Sorry,can`t find the Driver!");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return userdto;
	}

	public void delete(UserDto user) {
		// TODO Auto-generated method stub
		//getHibernateTemplate().delete(user);
		String driver = "com.mysql.jdbc.Driver";
    	// URL指向要访问的数据库名test1
    	String url = "jdbc:mysql://10.2.1.204:3306/intern";
    	// MySQL配置时的用户名
    	String username = "root";
    	// Java连接MySQL配置时的密码
    	String p_word = "123456";
    	try {
    		// 1 加载驱动程序
    		Class.forName(driver);
    		// 2 连接数据库
    		Connection conn = (Connection) DriverManager.getConnection(url, username, p_word);
    		String sql = "delete from user where id='"+user.getId()+"'";
    		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		pst.executeUpdate();
    		pst.close();
    		conn.close();
    	} catch (ClassNotFoundException e) {
    		System.out.println("Sorry,can`t find the Driver!");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}

	public void save(UserDto user) {
		// TODO Auto-generated method stub
		//getHibernateTemplate().save(user);
		String driver = "com.mysql.jdbc.Driver";
    	// URL指向要访问的数据库名test1
    	String url = "jdbc:mysql://10.2.1.204:3306/intern?characterEncoding=gbk";
    	// MySQL配置时的用户名
    	String username = "root";
    	// Java连接MySQL配置时的密码
    	String p_word = "123456";
    	try {
    		// 1 加载驱动程序
    		Class.forName(driver);
    		// 2 连接数据库
    		Connection conn = (Connection) DriverManager.getConnection(url, username, p_word);
    		// 要执行的SQL语句
    		String sql = "insert into user values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		pst.setString(1, user.getUsername());
    		pst.setString(2,user.getPassword());
    		pst.setString(3,user.getRealname());
    		pst.setString(4,user.getIdentity());
    		pst.setString(5,user.getEmail());
    		pst.setString(6,user.getPhone());
    		pst.setString(7,user.getInstitutionid());
    		pst.setString(8,user.getSubinstitutionid());
    		pst.setInt(9,user.getType());
    		pst.setString(10,user.getGender());
    		pst.setInt(11,user.getAge());
    		pst.setInt(12,user.getStatus());
    		pst.setString(13,user.getCountry());
    		pst.setString(14,user.getProvince());
    		pst.setString(15,user.getCity());
    		pst.setString(16,user.getDistrict());
    		pst.setString(17,user.getAddress());
    		pst.setFloat(18,user.getLon());
    		pst.setFloat(19,user.getLat());
    		pst.setString(20,user.getImgurl());
    		System.out.println(pst.asSql());
    		pst.executeUpdate(); 
    		pst.close();
    		conn.close();
    	} catch (ClassNotFoundException e) {
    		System.out.println("Sorry,can`t find the Driver!");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}

	public void update(UserDto user) {
		// TODO Auto-generated method stub
		//getHibernateTemplate().update(user);
		String driver = "com.mysql.jdbc.Driver";
    	// URL指向要访问的数据库名test1
    	String url = "jdbc:mysql://10.2.1.204:3306/intern?characterEncoding=gbk";
    	// MySQL配置时的用户名
    	String username = "root";
    	// Java连接MySQL配置时的密码
    	String p_word = "123456";
    	try {
    		// 1 加载驱动程序
    		Class.forName(driver);
    		// 2 连接数据库
    		Connection conn = (Connection) DriverManager.getConnection(url, username, p_word);
    		// 要执行的SQL语句
    		String sql = "update intern.user set username=?,password=?,realname=?,identity=?,email=?,phone=?,institutionid=?,subinstitutionid=?,type=?,gender=?,age=?,status=?,country=?,province=?,city=?,district=?,address=?,lon=?,lat=?,imgurl=? where id='"+user.getId()+"'";
    		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		pst.setString(1, user.getUsername());
    		pst.setString(2,user.getPassword());
    		pst.setString(3,user.getRealname());
    		pst.setString(4,user.getIdentity());
    		pst.setString(5,user.getEmail());
    		pst.setString(6,user.getPhone());
    		pst.setString(7,user.getInstitutionid());
    		pst.setString(8,user.getSubinstitutionid());
    		pst.setInt(9,user.getType());
    		pst.setString(10,user.getGender());
    		pst.setInt(11,user.getAge());
    		pst.setInt(12,user.getStatus());
    		pst.setString(13,user.getCountry());
    		pst.setString(14,user.getProvince());
    		pst.setString(15,user.getCity());
    		pst.setString(16,user.getDistrict());
    		pst.setString(17,user.getAddress());
    		pst.setFloat(18,user.getLon());
    		pst.setFloat(19,user.getLat());
    		pst.setString(20,user.getImgurl());
    		pst.executeUpdate(); 
    		pst.close();
    		conn.close();
    	} catch (ClassNotFoundException e) {
    		System.out.println("Sorry,can`t find the Driver!");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}

	public void saveOrUpdate(UserDto user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(user);
	}

	@Override
	public Map<String, Object> RegionalInfection_Suspected() {
		// TODO Auto-generated method stub
		/*Map<String,Integer> map = new HashMap<>();
        List<String> list= null;
        list = getHibernateTemplate().find("select distinct u.district from UserDto u");
        String dis = null;
        List<UserDto> u_list = new ArrayList<>();
        for(int i=0;i<=list.size();i++) {
        	dis = list.get(i);
        	u_list = getHibernateTemplate().find("from UserDto as p where p.status = 0 or p.status = 1");
        	map.put(dis, u_list.size());
        }*/
		Map<String,Object> map = new HashMap<>();
		List<String> list = new ArrayList<>() ;
		List<Integer> list_sum = new ArrayList<>() ;
		String dis;
		int sum_con=0;
		int sum_sus=0;
		String driver = "com.mysql.jdbc.Driver";
    	// URL指向要访问的数据库名test1
    	String url = "jdbc:mysql://10.2.1.204:3306/intern?characterEncoding=UTF-8";
    	// MySQL配置时的用户名
    	String user = "root";
    	// Java连接MySQL配置时的密码
    	String p_word = "123456";
    	try {
    		// 1 加载驱动程序
    		Class.forName(driver);
    		// 2 连接数据库
    		Connection conn = (Connection) DriverManager.getConnection(url, user, p_word);
    		// 3 用来执行SQL语句
    		Statement statement = (Statement) conn.createStatement();
    		// 要执行的SQL语句
    		String sql = "select DISTINCT district from user";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			list.add(rs.getString("district"));
    		}
    		for(int i=0;i<list.size();i++) {
    			dis = list.get(i);
    			rs = statement.executeQuery("select * from user where district = '"+dis+"' and status = 0");
    			while(rs.next()) {
    				sum_con ++;
        		}
    			rs = statement.executeQuery("select * from user where district = '"+dis+"' and status = 1");
    			while(rs.next()) {
    				sum_sus++;
    			}
    			list_sum.add(sum_con);
    			list_sum.add(sum_sus);			
    			sum_con=0;
    			sum_sus=0;
    		}
    		Map<String,Object>[]maps=new HashMap[list.size()];
    		for(int i=0;i<list.size();i++) {
    			maps[i]=new HashMap<>();
    		}
    		for(int i=0;i<list.size();i++) {
    			maps[i].put("name", list.get(i));
    			maps[i].put("comfirm",list_sum.get(2*i));
    			maps[i].put("suspect",list_sum.get(2*i+1));
    			//map.put((i+1)+"", maps[i]);
    		}
    		map.put("data", maps);
    		rs.close();
    		conn.close();
    	} catch (ClassNotFoundException e) {
    		System.out.println("Sorry,can`t find the Driver!");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return map;
	}

	@Override
	public UserDto findUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		//String[] params = {name,password};
		UserDto userdto = new UserDto();
        /*List<UserDto> users = getHibernateTemplate().find("from UserDto u where u.username = ? and u.password = ?",params);
        if(users.size() != 0) return users.get(0).getId();*/
        String driver = "com.mysql.jdbc.Driver";
    	// URL指向要访问的数据库名test1
    	String url = "jdbc:mysql://10.2.1.204:3306/intern";
    	// MySQL配置时的用户名
    	String user = "root";
    	// Java连接MySQL配置时的密码
    	String p_word = "123456";
    	try {
    		// 1 加载驱动程序
    		Class.forName(driver);
    		// 2 连接数据库
    		Connection conn = (Connection) DriverManager.getConnection(url, user, p_word);
    		// 3 用来执行SQL语句
    		Statement statement = (Statement) conn.createStatement();
    		// 要执行的SQL语句
    		String sql = "select * from user where username = '"+name+"' and password = '"+password+"'";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			userdto.setId(rs.getLong("id"));
    			userdto.setUsername(rs.getString("username"));
    			userdto.setImgurl(rs.getString("imgurl"));
    			userdto.setType(rs.getInt("type")); 
    		}
    		rs.close();
    		conn.close();
    	} catch (ClassNotFoundException e) {
    		System.out.println("Sorry,can`t find the Driver!");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return userdto;
        //else return -1;
	}

	@Override
	public Map<String, Object> getUserwithPage(int page, int limit) {
		// TODO Auto-generated method stub
		long id,total = 0;
		String name,gender,branch,tel,address;
		int i=0,risk,index=0;
		Map<String,Object> map = new HashMap<>();
		Map<String,Object>[]maps=new HashMap[limit];
		for(int j=0;j<limit;j++) {
			maps[j]=new HashMap<>();
		}
		String driver = "com.mysql.jdbc.Driver";
    	// URL指向要访问的数据库名test1
    	String url = "jdbc:mysql://10.2.1.204:3306/intern";
    	// MySQL配置时的用户名
    	String user = "root";
    	// Java连接MySQL配置时的密码
    	String p_word = "123456";
    	try {
    		// 1 加载驱动程序
    		Class.forName(driver);
    		// 2 连接数据库
    		Connection conn = (Connection) DriverManager.getConnection(url, user, p_word);
    		// 3 用来执行SQL语句
    		Statement statement = (Statement) conn.createStatement();
    		// 要执行的SQL语句
    		String sql = "select * from user";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()&&i<limit) {
    			if(index!=(page-1)*limit) {
    				index++;
    			}else {
    				id=rs.getLong("id");
    				name=rs.getString("username");
    				gender=rs.getString("gender");
    				branch=rs.getString("subinstitutionid");
    				tel=rs.getString("phone");
    				address=rs.getString("address");
    				risk=rs.getInt("status");
    				maps[i].put("id", id);
    				maps[i].put("name", name);
    				maps[i].put("gender", gender);
    				maps[i].put("branch", branch);
    				maps[i].put("tel", tel);
    				maps[i].put("address", address);
    				maps[i].put("risk", risk);
    				i++;
    			}
    		}
    		String sql1 = "select count(*) from user";
    		rs = statement.executeQuery(sql1);
    		while(rs.next()) {
    			total=rs.getInt(1);
    		}
    		if(i!=limit) {
    			Map<String,Object>[]maps_l=new HashMap[i];
    			for(int m=0;m<i;m++) {
    				maps_l[m]=new HashMap<>();
    				maps_l[m]=maps[m];
    			}
    			map.put("data", maps_l);
    			map.put("total", total);
    		}else {
    			map.put("data", maps);
    			map.put("total", total);
    		}   		
    		rs.close();
    		conn.close();
    	} catch (ClassNotFoundException e) {
    		System.out.println("Sorry,can`t find the Driver!");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return map;
	}

	@Override
	public Map<String, Object> Ratio_ReturnedWoker() {
		// TODO Auto-generated method stub
		int i=0,count0=0,count1=0,count2=0;
		Map<String,Object> map = new HashMap<>();
		Map<String,Object>[]maps=new HashMap[3];
		for(int j=0;j<3;j++) {
			maps[j]=new HashMap<>();
		}
		String driver = "com.mysql.jdbc.Driver";
    	// URL指向要访问的数据库名test1
    	String url = "jdbc:mysql://10.2.1.204:3306/intern";
    	// MySQL配置时的用户名
    	String user = "root";
    	// Java连接MySQL配置时的密码
    	String p_word = "123456";
    	try {
    		// 1 加载驱动程序
    		Class.forName(driver);
    		// 2 连接数据库
    		Connection conn = (Connection) DriverManager.getConnection(url, user, p_word);
    		// 3 用来执行SQL语句
    		Statement statement = (Statement) conn.createStatement();
    		// 要执行的SQL语句
    		String sql = "select count(*) from user where status=0";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			count0=rs.getInt(1);
    		}
    		maps[i].put("name", "isolated");
			maps[i].put("count", count0);
			i++;
			String sql1="select count(*) from user where status=1";
			rs = statement.executeQuery(sql1);
			while(rs.next()) {
    			count1=rs.getInt(1);
    		}
			maps[i].put("name", "remote");
			maps[i].put("count", count1);
			i++;
			String sql2="select count(*) from user where status=2";
			rs = statement.executeQuery(sql2);
			while(rs.next()) {
    			count2=rs.getInt(1);
    		}
			maps[i].put("name", "back to office");
			maps[i].put("count", count2);
    		map.put("data", maps);
    		rs.close();
    		conn.close();
    	} catch (ClassNotFoundException e) {
    		System.out.println("Sorry,can`t find the Driver!");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return map;
	}

	@Override
	public Map<String, Object> Ratio_Fever(String id) {
		// TODO Auto-generated method stub
		int i=0,count0=0,count1=0,count2=0;
		Map<String,Object> map = new HashMap<>();
		Map<String,Object>[]maps=new HashMap[2];
		for(int j=0;j<2;j++) {
			maps[j]=new HashMap<>();
		}
		String driver = "com.mysql.jdbc.Driver";
    	// URL指向要访问的数据库名test1
    	String url = "jdbc:mysql://10.2.1.204:3306/intern";
    	// MySQL配置时的用户名
    	String user = "root";
    	// Java连接MySQL配置时的密码
    	String p_word = "123456";
    	try {
    		// 1 加载驱动程序
    		Class.forName(driver);
    		// 2 连接数据库
    		Connection conn = (Connection) DriverManager.getConnection(url, user, p_word);
    		// 3 用来执行SQL语句
    		Statement statement = (Statement) conn.createStatement();
    		// 要执行的SQL语句
    		String sql = "select count(*) from user where status=0 and subinstitutionid = '"+id+"'";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			count0=rs.getInt(1);
    		}
			String sql1="select count(*) from user where status=1 and subinstitutionid = '"+id+"'";
			rs = statement.executeQuery(sql1);
			while(rs.next()) {
    			count1=rs.getInt(1);
    		}
			maps[i].put("name", "febrile");
			maps[i].put("count", count0+count1);
			i++;
			String sql2="select count(*) from user where status=2 and subinstitutionid = '"+id+"'";
			rs = statement.executeQuery(sql2);
			while(rs.next()) {
    			count2=rs.getInt(1);
    		}
			maps[i].put("name", "Normal");
			maps[i].put("count", count2);
    		map.put("data", maps);
    		rs.close();
    		conn.close();
    	} catch (ClassNotFoundException e) {
    		System.out.println("Sorry,can`t find the Driver!");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return map;
	}	

}

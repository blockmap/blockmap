package org.icbc.dataAccess.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.icbc.dataAccess.dto.SubinstitutionDto;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SubinstitutionDaoImpl extends HibernateDaoSupport implements ISubinstitutionDao{
	
	public boolean testHibernateTemplate(){
        if(getHibernateTemplate() == null)return false;
        return true;
    }
	@Override
	public SubinstitutionDto getById(Long id) {
		// TODO Auto-generated method stub
		return (SubinstitutionDto) getHibernateTemplate().get(SubinstitutionDto.class, id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		//getHibernateTemplate().delete(subinstitution);
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
    		String sql = "delete from subinstitution where id='"+id+"'";
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

	@Override
	public void save(SubinstitutionDto subinstitution) {
		// TODO Auto-generated method stub
		//getHibernateTemplate().save(subinstitution);
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
    		String sql = "insert into subinstitution values(0,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		pst.setString(1,subinstitution.getSubinstitutionname());
    		pst.setString(2,subinstitution.getInstitutionId());
    		pst.setString(3,subinstitution.getProfession());
    		pst.setString(4,subinstitution.getTel());
    		pst.setString(5,subinstitution.getProvince());
    		pst.setString(6,subinstitution.getCity());
    		pst.setString(7,subinstitution.getDistrict());
    		pst.setString(8,subinstitution.getStreet());
    		pst.setString(9,subinstitution.getDetailAddress());
    		pst.setFloat(10,subinstitution.getLon());
    		pst.setFloat(11,subinstitution.getLat());
    		pst.setDouble(12,subinstitution.getRiskLevel());
    		pst.setLong(13,subinstitution.getPassengerFlow());
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

	@Override
	public void update(SubinstitutionDto subinstitution) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(subinstitution);
	}

	@Override
	public void saveOrUpdate(SubinstitutionDto subinstitution) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(subinstitution);
	}
	@Override
	public List<SubinstitutionDto> selectWorkSubinstitution(int page, int limit) {
		// TODO Auto-generated method stub
		List<SubinstitutionDto> list = getHibernateTemplate().find("from SubinstitutionDto as t where t.riskLevel <= 1.0");
		return list;
	}
	@Override
	public List<String> rank5Subinstitution() {
		// TODO Auto-generated method stub
		/*List<SubinstitutionDto> list = getHibernateTemplate().find("from SubinstitutionDto as p where p.riskLevel <= 1 order by p.riskLevel ASC");
		return list;*/
		List<String> list = new ArrayList<>() ;
		int i=0;
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
    		String sql = "select * from subinstitution where riskLevel <=1 order by riskLevel ASC";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next() && i<=4) {
    			list.add(rs.getString("subinstitutionname"));
    			i++;
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
    	return list;
	}

	@Override
	public Map<String, Object> ReturnableWorker() {
		// TODO Auto-generated method stub
		/*Map<String,Integer> map = new HashMap<>();
        List<Integer> list= null;
        list = getHibernateTemplate().find("select DISTINCT s.institutionId from SubinstitutionDto s");
        List<UserDto> u_list = new ArrayList<>();
        for(int i=0;i<list.size();i++) {
        	int id = list.get(i);
        	u_list = getHibernateTemplate().find("from UserDto as p where p.status = 2 and p.institutionid =?",id);
        	InstitutionDto ins = (InstitutionDto) getHibernateTemplate().find("from InstitutionDto as p where p.id = ?",id);
        	map.put(ins.getInstitutionname(), u_list.size());
        }*/
		Map<String,Object> map = new HashMap<>();
		List<String> list = new ArrayList<>() ;
		String ins;
		long ins_l;
		int sum=0;
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
    		String sql = "select DISTINCT institutionId from subinstitution";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			list.add(rs.getString("institutionId"));
    		}
    		Map<String,Object>[]maps=new HashMap[list.size()];
    		for(int i=0;i<list.size();i++) {
    			maps[i]=new HashMap<>();
    		}
    		for(int i=0;i<list.size();i++) {
    			ins = list.get(i);
    			ins_l=Long.parseLong(ins);
    			rs = statement.executeQuery("select * from user where institutionid = '"+ins+"' and status = 2");
    			while(rs.next()) {
        			sum ++;
        		}
    			rs = statement.executeQuery("select * from institution where ins_id = '"+ins_l+"'");
    			while(rs.next()) {
    				ins = rs.getString("institutionname");
    			}
    			maps[i].put("name", ins);
    			maps[i].put("sum", sum);
    			sum=0;
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
	public Map<String, Object> RegionalPedestrianflow() {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		List<String> list = new ArrayList<>() ;
		String dis;
		int sum=0;
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
    		String sql = "select DISTINCT district from subinstitution";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			list.add(rs.getString("district"));
    		}
    		Map<String,Object>[]maps=new HashMap[list.size()];
    		for(int i=0;i<list.size();i++) {
    			maps[i]=new HashMap<>();
    		}
    		for(int i=0;i<list.size();i++) {
    			dis = list.get(i);
    			rs = statement.executeQuery("select * from subinstitution where district = '"+dis+"'");
    			while(rs.next()) {
    				System.out.println(rs.getLong(14));
        			sum += rs.getLong("passengerFlow");
        		}
    			System.out.println(sum);
    			maps[i].put("district", dis);
    			maps[i].put("passengerFlow", sum);
    			sum=0;
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
        /*List<String> list= null;
        list = getHibernateTemplate().find("select DISTINCT s.district from SubinstitutionDto s");
        String dis = null;
        List<UserDto> u_list = new ArrayList<>();
        for(int i=0;i<list.size();i++) {
        	dis = list.get(i);
        	u_list = getHibernateTemplate().find("from UserDto as p where p.district = ?",dis);
        	System.out.println(dis+" "+u_list.size());
        	map.put(dis, u_list.size());
        }*/
		return map;
	}
	@Override
	public Map<String,Object> AllSubinstitution() {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		List<String> list = new ArrayList<>() ;
		List<Long> list_id = new ArrayList<>() ;
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
    		String sql = "select * from subinstitution";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			list_id.add(rs.getLong("id"));
    			list.add(rs.getString("subinstitutionname"));
    		}
    		Map<String,Object>[]maps=new HashMap[list.size()];
    		for(int j=0;j<list.size();j++) {
    			maps[j]=new HashMap<>();
    			maps[j].put("id", list_id.get(j));
    			maps[j].put("name", list.get(j));
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
	public Map<String, Object> getSubinstitutionwithPage(int page, int limit) {
		// TODO Auto-generated method stub
		long id,total=0;
		String branch,tel,address;
		int i=0,count=0,index=0;
		Map<String,Object> map = new HashMap<>();
		Map<String,Object>[]maps=new HashMap[limit];
		List<Long> list=new ArrayList<>();
		List<Integer> list_sum=new ArrayList<>();
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
    		String sql = "select id from subinstitution";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			list.add(rs.getLong("id"));
    		}
    		for(int k=0;k<list.size();k++) {
    			String sql1 = "select count(*) from user where subinstitutionid = '"+list.get(k)+"'";
        		rs = statement.executeQuery(sql1);
        		while(rs.next()) {
        			list_sum.add(rs.getInt(1));
        		}
    		}
    		String sql2 = "select * from subinstitution";
    		rs = statement.executeQuery(sql2);
    		int m=(page-1)*limit;
    		while(rs.next()&&i<limit) {
    			if(index!=(page-1)*limit) {
    				index++;
    			}else {
    				id=rs.getLong("id");
    				branch=rs.getString("subinstitutionname");
    				tel=rs.getString("tel");
    				address=rs.getString("detailAddress");
    				count=list_sum.get(m++);
    				maps[i].put("id", id);
    				maps[i].put("branch", branch);
    				maps[i].put("tel", tel);
    				maps[i].put("address", address);
    				maps[i].put("tel", tel);
    				maps[i].put("count", count);
    				i++;
    				
    			}
    		}
    		String sql3 = "select count(*) from subinstitution";
    		rs = statement.executeQuery(sql3);
    		while(rs.next()) {
    			total=rs.getInt(1);
    		}
    		if(i!=limit) {
    			Map<String,Object>[]maps_l=new HashMap[i];
    			for(int n=0;n<i;n++) {
    				maps_l[n]=new HashMap<>();
    				maps_l[n]=maps[n];
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

}

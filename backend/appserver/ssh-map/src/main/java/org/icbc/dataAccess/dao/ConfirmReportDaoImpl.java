package org.icbc.dataAccess.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.icbc.dataAccess.dto.ConfirmReportDto;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ConfirmReportDaoImpl extends HibernateDaoSupport implements IConfirmReportDao{
	public boolean testHibernateTemplate(){
        if(getHibernateTemplate() == null)return false;
        return true;
    }

	@Override
	public Map<String, Object> getConfirmReportwithPage(int page, int limit) {
		// TODO Auto-generated method stub
		long id,total=0;
		String name,confirmed,date,symptoms;
		int i=0,index=0;
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
    		String sql = "select * from confirmreport";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()&&i<limit) {
    			if(index!=(page-1)*limit) {
    				index++;
    			}else {
    				id=rs.getLong("id");
    				name=rs.getString("name");
    				confirmed=rs.getString("confirmed");
    				date=rs.getString("date");
    				symptoms=rs.getString("symptoms");
    				maps[i].put("id", id);
    				maps[i].put("name", name);
    				maps[i].put("confirmed", confirmed);
    				maps[i].put("date", date);
    				maps[i].put("symptoms", symptoms);
    				i++;
    			}
    		}
    		String sql1 = "select count(*) from confirmreport";
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
	public void delete(long id) {
		// TODO Auto-generated method stub
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
    		String sql = "delete from confirmreport where id='"+id+"'";
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
	public void save(ConfirmReportDto confirmreport) {
		// TODO Auto-generated method stub
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
    		String sql = "insert into confirmreport values(0,?,?,?,?)";
    		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		pst.setString(1,confirmreport.getName());
    		pst.setString(2,confirmreport.getConfirmed());
    		pst.setString(3,confirmreport.getDate());
    		pst.setString(4,confirmreport.getSymptoms());
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
}

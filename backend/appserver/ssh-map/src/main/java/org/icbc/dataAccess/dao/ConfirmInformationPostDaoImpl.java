package org.icbc.dataAccess.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.icbc.dataAccess.dto.ConfirmInformationPostDto;
import org.icbc.tool.ResultUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ConfirmInformationPostDaoImpl extends HibernateDaoSupport implements IConfirmInformationPostDao{

	public boolean testHibernateTemplate(){
        if(getHibernateTemplate() == null)return false;
        return true;
    }
	@Override
	public ConfirmInformationPostDto getById(Long id) {
		// TODO Auto-generated method stub
		return (ConfirmInformationPostDto) getHibernateTemplate().get(ConfirmInformationPostDto.class, id);
	}

	@Override
	public void delete(ConfirmInformationPostDto confirm) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(confirm);
	}

	@Override
	public void save(ConfirmInformationPostDto confirm,long id,int status) {
		// TODO Auto-generated method stub
		//getHibernateTemplate().save(confirm);
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
    		String sql = "insert into confirmInformationPost values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		pst.setString(1, confirm.getUsername());
    		pst.setString(2, confirm.getBranch());
    		pst.setString(3,confirm.getGender());
    		pst.setInt(4,confirm.getAge());
    		pst.setString(5,confirm.getEmail());
    		pst.setString(6,confirm.getPhone());
    		pst.setString(7,confirm.getProvince());
    		pst.setString(8,confirm.getCity());
    		pst.setString(9,confirm.getDistrict());
    		pst.setString(10,confirm.getDetailAddress());
    		pst.setString(11,confirm.getConfirmDate());
    		pst.setString(12,confirm.getPathPost());
    		pst.setString(13, confirm.getDescription());
    		pst.setString(14, confirm.getState());
    		pst.setLong(15, id);
    		pst.executeUpdate(); 
    		String sql1 = "update intern.user set status = '"+status+"' where id = '"+id+"'";
    		pst = (PreparedStatement) conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
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
	public void update(ConfirmInformationPostDto confirm) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(confirm);
	}

	@Override
	public void saveOrUpdate(ConfirmInformationPostDto confirm) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(confirm);
	}
	@Override
	public void updatestate(long id) {
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
    		String sql = "update confirmInformationPost set state = 'finished' where comfirm_id = '"+id+"'";
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
	public Map<String, Object> getComfirmPostwithPage(int page, int limit) {
		// TODO Auto-generated method stub
		long id,total=0;
		String username,branch,tel,address,description,date,state;
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
    		String sql = "select * from confirmInformationPost";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()&&i<limit) {
    			if(index!=(page-1)*limit) {
    				index++;
    			}else {
    				id=rs.getLong("comfirm_id");
    				username=rs.getString("username");
    				branch=rs.getString("branch");
    				tel=rs.getString("phone");
    				address=rs.getString("detailAddress");
    				description=rs.getString("description");
    				date=rs.getString("confirmDate");
    				state=rs.getString("state");   				
    				maps[i].put("id", id);
    				maps[i].put("username", username);
    				maps[i].put("branch", branch);
    				maps[i].put("tel", tel);
    				maps[i].put("address", address);
    				maps[i].put("description", description);
    				maps[i].put("date", date);
    				maps[i].put("state", state);
    				i++;
    			}
    		}
    		String sql1 = "select count(*) from confirmInformationPost";
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
    			map.put("status", "success");
    		}else {
    			map.put("data", maps);
    			map.put("total", total);
    			map.put("status", "success");
    		}
    		ResultUtils.toJson(ServletActionContext.getResponse(), map);
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
		return null;
	}

}

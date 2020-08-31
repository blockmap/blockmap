package org.icbc.dataAccess.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.icbc.dataAccess.dto.InstitutionDto;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class InstitutionDaoImpl extends HibernateDaoSupport implements IInstitutionDao{

	
	public boolean testHibernateTemplate(){
        if(getHibernateTemplate() == null)return false;
        return true;
    }
	
	@Override
	public void addNewInstitution(InstitutionDto ins) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(ins);
	}

	@Override
	public void UpdateInstitution(InstitutionDto ins) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(ins);
	}

	@Override
	public void DeleteInstitution(InstitutionDto ins) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(ins);
	}

	@Override
	public Map<String, Object> ReturnableCompany() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		int sum=0;
		Map<String,Object>[]maps=new HashMap[8];
		for(int i=0;i<8;i++) {
			maps[i]=new HashMap<>();
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
    		String sql = "select * from institution where profession = 'public service' and isreturnable = 1";
    		ResultSet rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			 sum++;
    		}
    		maps[0].put("profession", "public service");
    		maps[0].put("sum", sum);
    		sum=0;
    		String sql1 = "select * from institution where profession = 'finance' and isreturnable = 1";
    		rs = statement.executeQuery(sql1);
    		while(rs.next()) {
    			 sum++;
    		}
    		maps[1].put("profession", "finance");
    		maps[1].put("sum", sum);
    		sum=0;
    		String sql2 = "select * from institution where profession = 'estate' and isreturnable = 1";
    		rs = statement.executeQuery(sql2);
    		while(rs.next()) {
    			 sum++;
    		}
    		maps[2].put("profession", "estate");
    		maps[2].put("sum", sum);
    		sum=0;
    		String sql3 = "select * from institution where profession = 'accomodation' and isreturnable = 1";
    		rs = statement.executeQuery(sql3);
    		while(rs.next()) {
    			 sum++;
    		}
    		maps[3].put("profession", "accomodation");
    		maps[3].put("sum", sum);
    		sum=0;
    		String sql4 = "select * from institution where profession = 'retail' and isreturnable = 1";
    		rs = statement.executeQuery(sql4);
    		while(rs.next()) {
    			 sum++;
    		}
    		maps[4].put("profession", "retail");
    		maps[4].put("sum", sum);
    		sum=0;
    		String sql5 = "select * from institution where profession = 'tourism' and isreturnable = 1";
    		rs = statement.executeQuery(sql5);
    		while(rs.next()) {
    			 sum++;
    		}
    		maps[5].put("profession", "tourism");
    		maps[5].put("sum", sum);
    		sum=0;
    		String sql6 = "select * from institution where profession = 'it' and isreturnable = 1";
    		rs = statement.executeQuery(sql6);
    		while(rs.next()) {
    			 sum++;
    		}
    		maps[6].put("profession", "it");
    		maps[6].put("sum", sum);
    		sum=0;
    		String sql7 = "select * from institution where profession = 'chemical' and isreturnable = 1";
    		rs = statement.executeQuery(sql7);
    		while(rs.next()) {
    			 sum++;
    		}
    		maps[7].put("profession", "chemical");
    		maps[7].put("sum", sum);
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
		/*List<InstitutionDto> list = getHibernateTemplate().find("from InstitutionDto as p where p.profession = 'public service' and p.isreturnable = 1");
		map.put("public service", list.size());
		list = getHibernateTemplate().find("from InstitutionDto as p where p.profession = 'finance' and p.isreturnable = 1");
		map.put("finance", list.size());
		list = getHibernateTemplate().find("from InstitutionDto as p where p.profession = 'estate' and p.isreturnable = 1");
		map.put("estate", list.size());
		list = getHibernateTemplate().find("from InstitutionDto as p where p.profession = 'accomodation' and p.isreturnable = 1");
		map.put("accomodation", list.size());
		list = getHibernateTemplate().find("from InstitutionDto as p where p.profession = 'retail' and p.isreturnable = 1");
		map.put("retail", list.size());
		list = getHibernateTemplate().find("from InstitutionDto as p where p.profession = 'tourism' and p.isreturnable = 1");
		map.put("tourism", list.size());
		list = getHibernateTemplate().find("from InstitutionDto as p where p.profession = 'IT' and p.isreturnable = 1");
		map.put("IT", list.size());
		list = getHibernateTemplate().find("from InstitutionDto as p where p.profession = 'chemical' and p.isreturnable = 1");
		map.put("chemical", list.size());*/
		return map;
	}

	@Override
	public InstitutionDto getById(Long id) {
		// TODO Auto-generated method stub
		return (InstitutionDto) getHibernateTemplate().get(InstitutionDto.class, id);
	}

}

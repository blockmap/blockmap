package Test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.icbc.bussinessService.ISubinstitutionService;
import org.icbc.bussinessService.SubinstitutionServiceImpl;
import org.icbc.dataAccess.dao.ISubinstitutionDao;
import org.icbc.dataAccess.dao.SubinstitutionDaoImpl;
import org.icbc.dataAccess.dto.SubinstitutionDto;
import org.icbc.dataAccess.dto.UserDto;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDemo {
	@Test
	public void testExample() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ApplicationContext context=new ClassPathXmlApplicationContext("hibernate.xml");
		ISubinstitutionDao subdao = (ISubinstitutionDao) context.getBean("SubinstitutionDao");
		List<SubinstitutionDto> list = new ArrayList<>();
		for (SubinstitutionDto s : list) {
            System.out.println(s.getId()+"  "+s.getSubinstitutionname()+"  "+s.getDistrict()+" "+s.getRiskLevel());
		}
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}

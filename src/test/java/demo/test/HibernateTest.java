package demo.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.domain.Role;

public class HibernateTest {
	public void test() {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Role r where r.id='c9d77d68-d03d-4073-9166-3abbbdbb533c'");
		Role role = (Role) query.list().get(0);
		Query query2 = session.createQuery("from Role r where r.fatherRole.id='"+role.getId()+"'");
		assert query2.list().size()==1;
	}
}

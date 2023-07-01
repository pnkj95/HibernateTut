package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableTest {

	public static void main(String[] args) {


		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Student s1 = new Student();
		s1.setCity("Delhi");
		s1.setName("Ashok");
		
		Certificate c1 = new Certificate();
		c1.setCourse("Java");
		c1.setCourse("6 months");
		s1.setCerti(c1);
		
		Student s2 = new Student();
		s2.setCity("BLR");
		s2.setName("Jagan");
		
		Certificate c2 = new Certificate();
		c2.setCourse("Spring");
		c2.setCourse("2 months");
		s2.setCerti(c2);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s1);
		session.save(s2);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}

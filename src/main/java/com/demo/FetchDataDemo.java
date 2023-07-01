package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDataDemo {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Student s = session.get(Student.class, 5);
		Student s1 = session.load(Student.class, 5);
		System.out.println(s);
		System.out.println(s1);
		
		session.close();
		
		
		sessionFactory.close();
		
	}
}

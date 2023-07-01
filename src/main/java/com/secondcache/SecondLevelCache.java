//Second Level Cache associated with SessionFactory and it requires to enabled explicitly. We can fetch data within multiple sessions and without hitting the db again and again
package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session1 = factory.openSession();
		
		Student5 student1 = session1.get(Student5.class, 100);
		System.out.println(student1);
		session1.close();
		
		Session session2 = factory.openSession();
		
		Student5 student2 = session2.get(Student5.class, 100);
		System.out.println(student2);
		
		session2.close();
	}
}

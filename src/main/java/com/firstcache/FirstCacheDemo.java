package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.obj.states.Student;

//First level cache associated with Session object. If we try to fetch the same object again during the opened session, it won't go and hit db for next time. It stores the first fetched result inside cache of Session object

public class FirstCacheDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student student = session.get(Student.class,100);
		System.out.println(student);
		System.out.println("____________________barrier to check first level cache_________");
		
		Student student2 = session.get(Student.class,100);
		System.out.println(student2);
	}
}

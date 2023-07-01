package com.hibernate.obj.states;


import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class ObjStateDemo {

	public static void main(String[] args) {
		
		//Hibernate Object states
		//Transient
		//Persistent
		//Detached
		//Removed
		System.out.println("Example of Object States");
		
		org.hibernate.SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Student student = new Student();
		student.setId(1);
		student.setName("Ram");
		student.setCity("test city");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Java");
		certificate.setDuration("6 months");
		
		student.setCerti(certificate);
		//transient state
		
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		//persistent state
		session.save(student);
		
		//value will be updated to database because entity is in persistent state before transaction commit 
		student.setCity("Jammu");
		
		tx.commit();
		
		
		session.close();
		factory.close();
	}
}

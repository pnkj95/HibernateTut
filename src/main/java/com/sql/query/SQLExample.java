package com.sql.query;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.hibernate.obj.states.Student;

public class SQLExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//table name should be referenced from database 
		String query = "select * from mystudents";
		
		NativeQuery nq = session.createSQLQuery(query);
		List<Object[]> students = nq.list();
		
		for(Object[] student : students) {
			System.out.println(student[4]+" : "+student[3]);
		}
				
		session.close();
		factory.close();
	}
}

package com.hql.pagination;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.obj.states.Certificate;
import com.hibernate.obj.states.Student;

public class HQLPagination {

	//HQL Pagination
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Query<Student> query = session.createQuery("from Student",Student.class);
		//first index from which we want to fetch result i.e. fetching result of 100 rows from 10th row
		query.setFirstResult(100);
		query.setMaxResults(10);
		
		List<Student> students = query.list();
		
		students.forEach(s-> System.out.println(s.getId() + ": "+s.getName()+": "+s.getCity()));
		
		session.close();
		
		factory.close();
	}
}

package com.hql.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.obj.states.Student;

public class HQLDemo {


	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//HQL
		//Fetch data from DB
		String query = "From Student s where s.city = :city and s.name = :n ";
		Query q1 = session.createQuery(query);
		q1.setParameter("city", "Noida");
		q1.setParameter("n", "Ram");
		List<Student> list =  q1.list();

		for(Student s : list) {
			System.out.println("name : "+s.getName()+" city : "+s.getCity());
		}
		
		System.out.println("_________________________________________________________");
		//Delete HQL
		Query q2 = session.createQuery("delete from Student s where s.name = :n");
		q2.setParameter("n", "Ram");
		int result = q2.executeUpdate();
//		tx.commit();
		System.out.println("Deleted with rc : "+result);
		
		System.out.println("____________________________________________________________");
		
		//Update HQL
		Query q3 = session.createQuery("UPDATE Student s set s.name = :name where s.city = :city");
		q3.setParameter("name", "Richa");
		q3.setParameter("city", "BLR");
		
		int result1 = q3.executeUpdate();
		tx.commit();
		System.out.println("Records updated with rc: "+result1);
		
		
		//Executing Join with HQL
		Query q4 = session.createQuery("select q.question,q.questionId, a.answer from Question1 q INNER JOIN q.answers a");
		q4.list();
		List<Object []> l = q4.getResultList();
		
		for(Object[] arr : l) {
			System.out.println(Arrays.toString(arr));
		}
		session.close();
		sessionFactory.close();
	}
}

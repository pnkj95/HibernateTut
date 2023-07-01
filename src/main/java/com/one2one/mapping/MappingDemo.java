package com.one2one.mapping;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {


		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		
		Question question1 = new Question();
		question1.setQuestionId(1);
		question1.setQuestion("What is Java?");
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(1);
		answer1.setAnswer("A high level programming language");
		answer1.setQuestion(question1);
		question1.setAnswer(answer1);
		
		Question question2 = new Question();
		question2.setQuestionId(2);
		question2.setQuestion("What is Collection?");
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(2);
		answer2.setAnswer("API to store group of objects");
		answer2.setQuestion(question2);
		question2.setAnswer(answer2);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(question1);
		session.save(question2);
		
		tx.commit();
		
		session.close();
		factory.close();
		

	}

}

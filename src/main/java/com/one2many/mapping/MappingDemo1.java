package com.one2many.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo1 {

	public static void main(String[] args) {


		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		
		//creating question
		Question1 question1 = new Question1();
		question1.setQuestionId(1);
		question1.setQuestion("What is Java?");
		
		//creating list of answers
		Answer1 answer1 = new Answer1();
		answer1.setAnswerId(1);
		answer1.setAnswer("A high level programming language");
		answer1.setQuestion(question1);
		
		
		Answer1 answer2 = new Answer1();
		answer2.setAnswerId(2);
		answer2.setAnswer("Java have my frameworks");
		answer2.setQuestion(question1);
		
		Answer1 answer3 = new Answer1();
		answer3.setAnswerId(3);
		answer3.setAnswer("Platform Independent Language");
		answer3.setQuestion(question1);
		
		List<Answer1> answers = new ArrayList<Answer1>();
		answers.add(answer1);
		answers.add(answer2);
		answers.add(answer3);
		
		question1.setAnswers(answers);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(question1);
		
		tx.commit();
		
		session.close();
		factory.close();
		

	}

}

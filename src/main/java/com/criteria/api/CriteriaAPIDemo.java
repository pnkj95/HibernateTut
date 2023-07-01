package com.criteria.api;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javassist.compiler.ast.ASTList;

public class CriteriaAPIDemo {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Criteria cr = session.createCriteria(Student6.class);
		
		//cr.add(Restrictions.eq("certi.course", "Java_485"));
		//cr.add(Restrictions.gt("id", 590));
		//cr.add(Restrictions.ilike("certi.course","%93"));
		//cr.add(Restrictions.ilike("certi.course","Jav%"));
		
		//To sort the column
		cr.addOrder(Order.desc("id"));
		
		
		// To get total row count.
		//cr.setProjection(Projections.rowCount());

		// To get average of a property.
		//cr.setProjection(Projections.avg("salary"));

		// To get distinct count of a property.
		//cr.setProjection(Projections.countDistinct("firstName"));

		// To get maximum of a property.
		//cr.setProjection(Projections.max("salary"));

		// To get minimum of a property.
		//cr.setProjection(Projections.min("salary"));

		// To get sum of a property.
		//cr.setProjection(Projections.sum("salary"));

		List<Student6> stList = cr.list();
		stList.forEach(s -> System.out.println(s));
		
		
	}
	

	
	
	
}

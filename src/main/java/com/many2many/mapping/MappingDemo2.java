//In this case, the parent class will be Employee and child class will be Project. The mapping will be done like 1 employee can have many projects in join table and mappedBy will play an important role to achieve this
//If we want to have mapping for 1 project have many employees in join table, then we can make Project as parent and add mappedBy in the child table 
package com.many2many.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo2 {

	public static void main(String[] args) {


		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		
//		To save the data to database
//		Employee e1 = new Employee();
//		e1.setEid(1);
//		e1.setEmployeeName("Ram");
//		
//		Employee e2 = new Employee();
//		e2.setEid(2);
//		e2.setEmployeeName("Shyam");
//		
//		
//		Project p1 = new Project();
//		p1.setPid(1);
//		p1.setProjectName("Library Management System");
//		
//		Project p2 = new Project();
//		p2.setPid(2);
//		p2.setProjectName("Test Project");
//		
//		List<Employee> empList = new ArrayList<Employee>();
//		empList.add(e1);
//		empList.add(e2);
//		
//		List<Project> projList = new ArrayList<Project>();
//		projList.add(p1);
//		projList.add(p2);
//		
//		//Association projects with emps
//		e1.setProjects(projList);
//		//e2.setProjects(projList);
//		
//		//Association emps with projects
//		p2.setEmps(empList);
//		p1.setEmps(empList);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//		session.save(e1);
//		session.save(e2);
//		session.save(p1);
//		session.save(p2);
		
//		Fetch Data from DB
		Employee employee =  session.get(Employee.class, 1);
		
		List<Project> projects = session.get(Employee.class, 1).getProjects();
		
		System.out.println(employee.getEmployeeName());
		
		projects.forEach(p -> System.out.println(p.getProjectName()));
		
		tx.commit();
		
		session.close();
		factory.close();
		

	}

}

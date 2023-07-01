package com.demo;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started!" );
        
        //both processes can be followed to get the Session Factory Object
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();
        System.out.println("SessionFactory : "+factory);
        System.out.println(factory.isOpen());
      //Session session = sessionFactory.openSession();
        Session session = factory.openSession();
        System.out.println("Session : "+session);
        
        Student s = new Student();
        s.setName("Aman");
        s.setCity("BLR");
        System.out.println(s);
        
        //address class object
        
        Address address = new Address();
        address.setCity("Noida");
        address.setStreet("Sec-62");
        address.setOpen(false);
        address.setAddedDate(new Date());
        address.setX(111.222);
        //reading image
        //address.setImage(null);
        FileInputStream inputStream = new FileInputStream("src/main/java/test.jpg");
        byte[] data = new byte[inputStream.available()];
        address.setImage(data);
        
        Transaction tx =  session.beginTransaction();
        session.save(s);
        session.save(address);
        tx.commit();
        session.close();
        System.out.println("done###########");
        
        
    }
}

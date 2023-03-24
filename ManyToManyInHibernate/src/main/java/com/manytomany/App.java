package com.manytomany;

import java.util.ArrayList;
import java.util.List;

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
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure();
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	Emp e1 = new Emp();
    	e1.setEid(34);
    	e1.setName("Ram");
    	
    	Emp e2 = new Emp();
    	e2.setEid(35);
    	e2.setName("Shyam");
    	
    	
    	Project p1 = new Project();
    	p1.setPid(12121);
    	p1.setProjectName("Library Management System");
    	
    	Project p2 = new Project();
    	p2.setPid(14121);
    	p2.setProjectName("CHATBOT");
    	
    	List<Emp> emplist=new ArrayList();
    	
    	emplist.add(e1);
    	emplist.add(e2);
    	
    	List<Project> prolist=new ArrayList();
    	prolist.add(p1);
    	prolist.add(p2);
    	
    	e1.setProjects(prolist);
    	p2.setEmps(emplist);
    	
    	
    	Session session=factory.openSession();
    	Transaction tx=session.beginTransaction();
    	
    	session.save(e1);
    	session.save(e2);
    	session.save(p1);
    	session.save(p2);
    	
    	tx.commit();
    	session.close();
    	
    	factory.close();
    	
    	
    }
}

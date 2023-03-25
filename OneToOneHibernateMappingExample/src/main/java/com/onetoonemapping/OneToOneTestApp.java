package com.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneTestApp 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		
		//Creating Question1
		
		 Question q1 = new Question();
		 q1.setQuestionId(1212);
		 q1.setQuestion("what is java?");
		 
		 //Creating Answer1
		 
		 Answer answer1 = new Answer();
		 answer1.setAnswerId(343);
		 answer1.setAnswer("Java is a Programming language");
		 q1.setAnswer(answer1);
		 
			
			  //Creating Question2
			  
			  Question q2 = new Question(); q2.setQuestionId(242);
			  q2.setQuestion("what is Collection Framework");
			  
			  
			  //Creating Answer2
			  
			  Answer answer2 = new Answer(); answer2.setAnswerId(344);
			  answer2.setAnswer("API to work with objects in java"); q2.setAnswer(answer2);
			 
		 
		 //session we need it to save the object
		 
		 Session s=factory.openSession();
		 Transaction tx=s.beginTransaction();
		 
		 //Save
		 
		 s.save(q1);
		 s.save(q2);
		 
		 tx.commit();
		 
		 s.close();
		factory.close();
		
	}

}


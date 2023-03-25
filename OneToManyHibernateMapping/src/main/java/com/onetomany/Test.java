package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test 
{
    public static void main( String[] args ){
    	
    	Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		//Creating Question1
		
		 Question q1 = new Question();
		 q1.setQuestionId(1);
		 q1.setQuestion("what is java?");
		 
		 //Creating Answer1
		 
		 Answer answer1 = new Answer();
		 answer1.setAnswerId(343);
		 answer1.setAnswer("Java is a Programming language");
		 answer1.setQuestion(q1);
		 
		 Answer answer2 = new Answer();
		 answer2.setAnswerId(344);
		 answer2.setAnswer("With the help of java wecan create softwares");
		 answer2.setQuestion(q1);
		 
		 Answer answer3 = new Answer();
		 answer3.setAnswerId(363);
		 answer3.setAnswer("Java has different types of frameworks.");
		 answer3.setQuestion(q1);
		 
		 
		 List<Answer> list=new ArrayList<Answer>();
		 list.add(answer1);
		 list.add(answer2);
		 list.add(answer3);
		 q1.setAnswers(list); 
		 
		 //session we need it to save the object
		 
		 Session s=factory.openSession();
		 
		 Transaction tx=s.beginTransaction();
		 
		 //Save
		 
		 s.save(q1);
		 s.save(answer1);
		 s.save(answer2);
		 s.save(answer3);
		
		 
		 tx.commit();
		 
		 s.close();
		factory.close();
		
	}

}


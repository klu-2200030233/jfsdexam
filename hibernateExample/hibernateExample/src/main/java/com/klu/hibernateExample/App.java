package com.klu.hibernateExample;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
    	Metadata md=new MetadataSources().getMetadataBuilder(ssr).build();
    	
    	SessionFactory sf=md.getSessionFactoryBuilder().build();
    	Session s=sf.openSession();
    	Transaction tr;
    	
    	Student st=new Student();
    	st.setName("kowshik");
    	tr=s.beginTransaction();
    	s.save(st);
    	tr.commit();
    	System.out.println("Data Inserted...");
    	
    	//Student st1 = s.find(Student.class, 4);
    	//st1.setName("Sai");
    	//tr.begin();
    	//s.update(st1);
    	//tr.commit();
    	//System.out.println("Data Updated...");
    	
    	//Student st2 = s.find(Student.class, 4);
    	//tr.begin();
    	//s.delete(st2);
    	//tr.commit();
        //System.out.println("Data deleted...");
    	
    	Criteria c = s.createCriteria(Student.class);
    	c.add(Restrictions.gt("id", 1));
    	List<Student> l= c.list();
    	for (Student s1: l) {
    		System.out.println("id= " + s1.getId() + ", name= " + s1.getName());
    		
    	}
    	
        Query<Student> qry = s.createQuery("select ST from Student ST where ST.id > 3", Student.class);
        List<Student> l2=qry.getResultList();
        for (Student s1: l2) {
          System.out.println("id= " + s1.getId() + ", name= " + s1.getName());  
        }
    	
    	
    	Acceleration ac = new Acceleration();
    	ac.setCourse("jfsd");
    	ac.setResult("Pass");
    	ac.setName("Ranganadha");
    	tr.begin();
    	s.save(ac);
    	tr.commit();
    	System.out.println("Acceleration inserted ");
    	
    	OddSemister ods = new OddSemister();
    	ods.setCourse("jfsd");
    	ods.setName("Ranganadha");
    	ods.setRegistration("Odd Sem");    	
    	tr.begin();
    	s.save(ods);
    	tr.commit();
    	System.out.println("Odd sem inserted");
    	
    	
    	
    	
    	
    	
    	
    }
}

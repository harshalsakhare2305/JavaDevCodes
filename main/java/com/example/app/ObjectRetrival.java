package com.example.app;

import com.example.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObjectRetrival {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session=null;

        try {
            session=sessionFactory.openSession();


            Student s = session.getReference(Student.class,1);

            // if  We notice the result from both the method we will notice that in the getReference method two time the constructor is called
            // means the object is been created twice
            // here is diff this method first creat the proxy object with just the primary key object and then if it find this not sufficient then it will create the
            // JDBC env and then applies the query
            // This is called as the lazy loading





           // Student s =session.get(Student.class,1);

            // get method will directly create the JDBC enviornmenr with out creating any proxy obect and query the data and then reutrn it if
            // data not found then it will return null instead of throwing the exception
            // but the get method is used to fetch the single record from the db
            // This is also called as the Eager loading

            if(s!=null){
                System.out.println(s);
            }else{
                System.out.println("Data not Found");
            }


        }catch (HibernateException e) {

            e.printStackTrace();
        }
        catch
         (Exception e) {
           e.printStackTrace();
        }
    }
}

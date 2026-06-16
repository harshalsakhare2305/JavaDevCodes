package com.example.app;

import com.example.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.UUID;

public class LaunchAppBetter {

    public static void main(String[] args) {

        Configuration config=null;
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction transaction=null;
        Boolean flag=false;

        config=new Configuration();
        config.configure();

        sessionFactory=config.buildSessionFactory();
        session=sessionFactory.openSession();

        try {
            transaction=session.beginTransaction();

            Student s1=new Student();

            s1.setId(UUID.randomUUID().toString());
            s1.setName("Pranav");
            s1.setAge(23);

            session.persist(s1);
            flag=true;


        }catch (HibernateException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(flag){
                transaction.commit();
            }else{
                transaction.rollback();
            }

            session.close();
            sessionFactory.close();
        }
    }
}

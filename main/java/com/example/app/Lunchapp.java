package com.example.app;

import com.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.UUID;

public class Lunchapp {

    public static void main(String[] args) {

        Configuration config =new Configuration();
        config.configure();

        SessionFactory sessionFactory=config.addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();

        Student s1 = new Student();
        s1.setId("1");
        s1.setName("Harshal");
        s1.setAge(22);


        session.persist(s1);

        transaction.commit();

        session.close();

    }
}

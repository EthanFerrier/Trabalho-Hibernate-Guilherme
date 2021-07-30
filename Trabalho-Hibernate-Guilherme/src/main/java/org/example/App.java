package com.hibernate;

import com.hibernate.entity.CommodityEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCommodity {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    // The test starts
    @Before
    public void init(){
        //Create a session factory
        sessionFactory = new Configuration().configure().buildSessionFactory();
        // Start a conversation
        session =sessionFactory.openSession();
        //Turn things on
        transaction = session.beginTransaction();
    }

    // End of test
    @After
    public void destory(){
        //Close things
        transaction.commit();
        //Close the conversation
        session.close();
        // Close the session factory
        sessionFactory.close();
    }
    // The following is the test case
    @Test
    public void testStudent(){
        CommodityEntity comm = new CommodityEntity();
        //If the id is a self-increasing column, no assignment is required, otherwise an error will be reported
        //comm.setId(3);
        comm.setSname("OPPOR15");
        comm.setBrand("OPPO");
        comm.setSid(2);
        comm.setSmoney(2400.0);
        session.save(comm);
    }

}
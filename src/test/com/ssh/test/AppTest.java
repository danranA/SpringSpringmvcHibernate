package com.ssh.test;

import com.ssh.entity.Dept;
import com.ssh.entity.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/27.
 */
public class AppTest {
    @Test
    public void fun1(){
    ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
       SessionFactory sqlsessionFactory = (SessionFactory) act.getBean("sqlSessionFactory");
        sqlsessionFactory.openSession();
        Session session = sqlsessionFactory.getCurrentSession();

    }

    @Test
    public void fun2(){
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sqlsessionFactory = (SessionFactory) act.getBean("sqlSessionFactory");
        Session session = sqlsessionFactory.getCurrentSession();
        Transaction txt = session.getTransaction();
        try {
            txt.begin();
           // Dept dept=new Dept(4,"444","444");
            Emp emp=new Emp(1,"name","job",123,new Date(),5f,1f);
            session.persist(emp);
            txt.commit();
        }catch (Exception e){
            e.printStackTrace();
            txt.rollback();
        }finally {
            session.close();
        }
    }
}

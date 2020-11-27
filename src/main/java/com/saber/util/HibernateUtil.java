package com.saber.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;

    static {
        SESSION_FACTORY = new Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
    private HibernateUtil(){}

    public static Session openSession() {
        ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();
        Session session = sessionThreadLocal.get();
        if (session == null) {
            session = SESSION_FACTORY.openSession();
            sessionThreadLocal.set(session);
        }
        return session;
    }
}

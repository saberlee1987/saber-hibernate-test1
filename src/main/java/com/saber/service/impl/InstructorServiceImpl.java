package com.saber.service.impl;

import com.saber.models.Instructor;
import com.saber.models.InstructorDetail;
import com.saber.service.InstructorService;
import com.saber.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    @Override
    public void addInstructor(Instructor instructor) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(instructor);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Instructor> findAll() {
        Session session = HibernateUtil.openSession();
        List<Instructor> instructorList = session.createNamedQuery("Instructor.findAll", Instructor.class).list();
        session.close();
        return instructorList;
    }

    @Override
    public Instructor findById(Integer id) {
        Session session = HibernateUtil.openSession();
        Instructor instructor = session.find(Instructor.class, id);
        session.close();
        return instructor;
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Instructor instructor = session.find(Instructor.class, id);
            if (instructor != null) {
                session.remove(instructor);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean deleteInstructorDetailById(Integer id) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            InstructorDetail instructorDetail = session.find(InstructorDetail.class, id);
            if (instructorDetail != null) {
                instructorDetail.getInstructor().setInstructorDetail(null);
                session.delete(instructorDetail);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }
    }
}
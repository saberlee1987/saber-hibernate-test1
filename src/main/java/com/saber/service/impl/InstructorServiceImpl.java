package com.saber.service.impl;

import com.saber.models.Course;
import com.saber.models.Instructor;
import com.saber.models.InstructorDetail;
import com.saber.models.Student;
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

    @Override
    public void addCourseToInstructor(Integer id, List<Course> courseList) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Instructor instructor = session.find(Instructor.class, id);
        if (instructor != null) {
            for (Course course : courseList) {
                instructor.addCourse(course);
                session.save(course);
            }
        }

        transaction.commit();
        session.close();
    }

    @Override
    public Course findCourseById(Integer id) {
        Session session = HibernateUtil.openSession();
        Course course = session.find(Course.class, id);
        System.out.println(course.getReviewList().size());
        session.close();
        return course;
    }

    @Override
    public void addCourse(Course course, List<Student> studentList) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        studentList.forEach(student -> {
            session.save(student);
            course.addStudent(student);
        });
        session.save(course);
        transaction.commit();
        session.close();
    }

    @Override
    public Student findStudent(Integer id) {
        Session session = HibernateUtil.openSession();
        Student student = session.find(Student.class, id);
        student.getCourseList().size();
        session.close();
        return student;
    }
}

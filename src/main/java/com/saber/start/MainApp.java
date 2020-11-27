package com.saber.start;

import com.saber.models.Course;
import com.saber.models.Instructor;
import com.saber.models.InstructorDetail;
import com.saber.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // addInstructorAndInstructorDetail();
        // Instructor instructor =findInstructorById(4);
        // System.out.println(instructor);
        // deleteInstructorDetail(1);
//        List<Course> courseList = new ArrayList<>(
//                Arrays.asList(
//                        new Course("Java SE"),
//                        new Course("Java EE"),
//                        new Course("Spring"),
//                        new Course("Spring MVC"),
//                        new Course("Spring Boot")
//                ) );
//
//        addCourseToInstructor(4,courseList);
    }

    private static void deleteInstructorDetail(Integer id) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        InstructorDetail instructorDetail = session.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        session.remove(instructorDetail);
        transaction.commit();

    }

    private static Instructor findInstructorById(Integer id) {
        Session session = HibernateUtil.openSession();
        Instructor instructor = session.find(Instructor.class, id);
        session.close();
        return instructor;
    }

    private static void addInstructorAndInstructorDetail() {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Instructor instructor = new Instructor();
        instructor.setFirstName("saber66");
        instructor.setLastName("Azizi");
        instructor.setEmail("saber66@yahoo.com");

        InstructorDetail detail = new InstructorDetail();
        detail.setYoutubeChannel("saber66@youtube.com");
        detail.setHobby("Java Channel");


        instructor.setInstructorDetail(detail);


        session.save(instructor);
        transaction.commit();

        System.out.println("add to DataBase ...............");

        session.close();

    }

    private static void addCourseToInstructor(Integer id, List<Course> courseList) {
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
}

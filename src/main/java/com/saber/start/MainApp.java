package com.saber.start;

import com.saber.models.Course;
import com.saber.models.Instructor;
import com.saber.models.InstructorDetail;
import com.saber.models.Review;
import com.saber.service.InstructorService;
import com.saber.service.impl.InstructorServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // addInstructorAndInstructorDetail();
        // Instructor instructor =findInstructorById(4);
        // System.out.println(instructor);
        // deleteInstructorDetail(1);

//        Course course = new Course();
//        course.setTitle("Java Programming");
//        course.addReview(new Review("I Love Java"));
//        course.addReview(new Review("I am good developer"));
//        course.addReview(new Review("I am  hayypy study this course"));
//        List<Course> courses = Arrays.asList(course);



//        List<Course> courseList = new ArrayList<>(
//                Arrays.asList(
//                        new Course("Java SE"),
//                        new Course("Java EE"),
//                        new Course("Spring"),
//                        new Course("Spring MVC"),
//                        new Course("Spring Boot")
//                ) );
//

        InstructorService instructorService =new InstructorServiceImpl();
//        addCourseToInstructor(1,courses,instructorService);
//        addInstructorAndInstructorDetail(instructorService);
        System.out.println(findCourseById(1,instructorService));
    }

    private static void deleteInstructorDetail(Integer id, InstructorService instructorService) {
        boolean flag= instructorService.deleteInstructorDetailById(id);
        if (flag){
            System.out.println("Instructor Detail ====> Deleted");
        }

    }

    private static Instructor findInstructorById(Integer id,InstructorService instructorService) {
        return instructorService.findById(id);
    }

    private static void addInstructorAndInstructorDetail(InstructorService instructorService) {

        Instructor instructor = new Instructor();
        instructor.setFirstName("saber66");
        instructor.setLastName("Azizi");
        instructor.setEmail("saber66@yahoo.com");

        InstructorDetail detail = new InstructorDetail();
        detail.setYoutubeChannel("saber66@youtube.com");
        detail.setHobby("Java Channel");

        instructor.setInstructorDetail(detail);

        instructorService.addInstructor(instructor);


        System.out.println("add to DataBase ...............");



    }

    private static void addCourseToInstructor(Integer id, List<Course> courseList,InstructorService instructorService) {
        instructorService.addCourseToInstructor(id,courseList);

    }

    private static Course findCourseById(Integer id, InstructorService instructorService){
        return instructorService.findCourseById(id);
    }
}

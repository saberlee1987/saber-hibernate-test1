package com.saber.start;

import com.saber.models.Course;
import com.saber.models.Instructor;
import com.saber.models.InstructorDetail;
import com.saber.service.InstructorService;
import com.saber.service.impl.InstructorServiceImpl;

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

        InstructorService instructorService =new InstructorServiceImpl();
        System.out.println(findCourseById(3,instructorService));
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

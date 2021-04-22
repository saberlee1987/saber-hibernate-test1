package com.saber.service;

import com.saber.models.Course;
import com.saber.models.Instructor;
import com.saber.models.Student;

import java.util.List;

public interface InstructorService {
    void addInstructor(Instructor instructor);
    List<Instructor> findAll();
    Instructor findById(Integer id);
    boolean deleteById(Integer id);
    boolean deleteInstructorDetailById(Integer id);
    void addCourseToInstructor(Integer id, List<Course> courseList);
    Course findCourseById(Integer id);
    void addCourse(Course course, List<Student> studentList);
    Student findStudent(Integer id);
}

package com.saber.service;

import com.saber.models.Instructor;

import java.util.List;

public interface InstructorService {
    void addInstructor(Instructor instructor);
    List<Instructor> findAll();
    Instructor findById(Integer id);
    boolean deleteById(Integer id);
    boolean deleteInstructorDetailById(Integer id);
}

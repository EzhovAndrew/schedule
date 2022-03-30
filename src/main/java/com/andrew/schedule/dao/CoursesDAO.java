package com.andrew.schedule.dao;

import com.andrew.schedule.models.Courses;

import java.util.List;

public interface CoursesDAO {
    Courses getById(Long id);
    List<Courses> getAll();
    void delete(Courses course);
    void save(Courses course);
    void update(Courses course);
//    List<Professors> getByFilter(
//            String name,
//            String surname,
//            String patronymic
//    );
}

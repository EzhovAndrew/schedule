package com.andrew.schedule.views;

import com.andrew.schedule.models.Courses;
import com.andrew.schedule.models.Professors;

import java.util.ArrayList;
import java.util.List;

public class CoursesView {
    public Long id;
    public String name;
    public String type;
    public String year;
    public Long times_per_week;

    public List<String> professors_full_names;

    public List<Long> delete_professors_ids;
    public List<Long> add_professors_ids;

    public List<Long> delete_students_ids;
    public List<Long> add_students_ids;

    public CoursesView() {}
    public CoursesView(Courses course) {
        id = course.getId();
        name = course.getName();
        type = course.getType();
        year = course.getYear();
        times_per_week = course.getTimes_per_week();
        if (course.getProfessors() != null) {
            professors_full_names = new ArrayList<>();
            for (Professors professor : course.getProfessors()) {
                professors_full_names.add(professor.getSurname() + " " + professor.getName() + " " + professor.getPatronymic());
            }
        }
    }
}

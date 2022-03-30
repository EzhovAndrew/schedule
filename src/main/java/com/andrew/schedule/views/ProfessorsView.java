package com.andrew.schedule.views;

import com.andrew.schedule.models.Courses;
import com.andrew.schedule.models.Professors;

import java.util.ArrayList;
import java.util.List;

public class ProfessorsView {
    public Long id;
    public String name;
    public String surname;
    public String patronymic;

    public List<Long> courses_ids;

    public ProfessorsView() {}
    public ProfessorsView(Professors professor) {
        id = professor.getId();
        name = professor.getName();
        surname = professor.getSurname();
        patronymic = professor.getPatronymic();

        courses_ids = new ArrayList<>();
        if (professor.getCourses() != null) {
            for (Courses course : professor.getCourses()) {
                courses_ids.add(course.getId());
            }
        }
    }
}

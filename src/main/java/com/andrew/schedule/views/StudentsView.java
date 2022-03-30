package com.andrew.schedule.views;

import com.andrew.schedule.models.Students;

public class StudentsView {
    public Long id;
    public String name;
    public String surname;
    public String patronymic;
    public Long year;
    public Long group;
    public Long stream;

    public StudentsView() {}
    public StudentsView(Students student) {
        id = student.getId();
        name = student.getName();
        surname = student.getSurname();
        patronymic = student.getPatronymic();
        year = student.getYear();
        group = student.getGroup();
        stream = student.getStream();
    }
}

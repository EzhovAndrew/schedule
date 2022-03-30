package com.andrew.schedule.views;

import com.andrew.schedule.models.Classrooms;

public class ClassroomView {
    public Long number;
    public Long capacity;

    public ClassroomView() {}
    public ClassroomView(Classrooms classroom) {
        number = classroom.getNumber();
        capacity = classroom.getCapacity();
    }
}

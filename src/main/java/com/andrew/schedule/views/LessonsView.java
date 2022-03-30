package com.andrew.schedule.views;

import com.andrew.schedule.models.Lessons;

import java.time.LocalDateTime;

public class LessonsView {
    public Long id;
    public LocalDateTime start_time;

    public String course_name;

    public Long course_id;
    public Long classroom_number;

    public LessonsView() {}
    public LessonsView(Lessons lesson) {
        id = lesson.getId();
        start_time = lesson.getStart_time();
        if (lesson.getCourse() != null) {
            course_name = lesson.getCourse().getName();
        }
    }
}

package com.andrew.schedule.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Getter
//@Setter
@Table(name = "lessons")
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_time")
    private LocalDateTime start_time;

    @ManyToOne()
    @JoinColumn(name = "classroom_num")
    private Classrooms classroom;

    @ManyToOne()
    @JoinColumn(name = "course_id")
    private Courses course;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getStart_time() { return start_time; }
    public Classrooms getClassroom() { return classroom; }
    public Courses getCourse() { return course; }

    public void setStart_time(LocalDateTime start_time) { this.start_time = start_time; }
    public void setClassroom(Classrooms classroom) { this.classroom = classroom; }
    public void setCourse(Courses course) { this.course = course; }

    public Lessons() {}
    public Lessons(Long id, LocalDateTime start_time, Classrooms classroom, Courses course) {
        this.id = id;
        this.start_time = start_time;
        this.classroom = classroom;
        this.course = course;
    }

    public String toString() {
        return "{" +
                "id:" + id +
                ",start_time:" + start_time +
                ",classroom:" + classroom.toString() +
                "}";
    }
}

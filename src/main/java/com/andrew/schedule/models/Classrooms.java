package com.andrew.schedule.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class Classrooms {
    @Id
    @Column(name = "number")
    private Long number;

    @Column(name = "capacity")
    private Long capacity;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Lessons> lessons;

    public Long getNumber() { return number; }
    public Long getCapacity() { return  capacity; }
    public List<Lessons> getLessons() { return lessons; }

    public void setNumber(Long number) { this.number = number; }
    public void setCapacity(Long capacity) { this.capacity = capacity; }
    public void setLessons(List<Lessons> lessons) { this.lessons = lessons;}

    public void removeLesson(Lessons lesson) {
        if (lessons != null) {
            lessons.remove(lesson);
        }
    }
    public void addLesson(Lessons lesson) {
        if (lessons == null) {
            lessons = new ArrayList<>();
        }
        lessons.add(lesson);
    }

    public Classrooms() {}
    public Classrooms(Long number, Long capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public String toString() {
        return "{" +
                "number: " + number +
                ",capacity: " + capacity +
                "}";
    }
}

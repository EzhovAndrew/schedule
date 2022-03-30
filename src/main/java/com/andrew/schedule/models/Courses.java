package com.andrew.schedule.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "year")
    private String year;
    @Column(name = "times_per_week")
    private Long times_per_week;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Lessons> lessons;

    @ManyToMany
    @JoinTable(
            name = "ProfessorsCourses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    List<Professors> professors;

    @ManyToMany
    @JoinTable(
            name = "StudentsCourses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    List<Students> students;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getYear() { return year; }
    public Long getTimes_per_week() { return times_per_week; }
    public List<Lessons> getLessons() { return lessons; }
    public List<Professors> getProfessors() { return professors; }
    public List<Students> getStudents() { return students; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setYear(String year) { this.year = year; }
    public void setTimes_per_week(Long times_per_week) { this.times_per_week = times_per_week; }
    public void setLessons(List<Lessons> lessons) { this.lessons = lessons;}
    public void setProfessors(List<Professors> professors) { this.professors = professors; }
    public void setStudents(List<Students> students) { this.students = students; }

    public Courses() {}
    public Courses(Long id, String name, String type, String year, Long times_per_week) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.year = year;
        this.times_per_week = times_per_week;
    }
    public Courses(String name, String type, String year, Long times_per_week) {
        this.name = name;
        this.type = type;
        this.year = year;
        this.times_per_week = times_per_week;
    }

    public void removeLesson(Lessons lesson) {
        if (lessons == null) {
            return;
        }
        lessons.remove(lesson);
        lesson.setCourse(null);
    }
    public void addLesson(Lessons lesson) {
        if (lessons == null) {
            lessons = new ArrayList<>();
        }
        lessons.add(lesson);
        lesson.setCourse(this);
    }

    public void removeProfessorById(Long id) {
        if (professors == null) {
            return;
        }
        for (Professors professor : professors) {
            if (professor.getId().compareTo(id) == 0) {
                professors.remove(professor);
                break;
            }
        }
    }
    public void addProfessor(Professors professor) {
        if (professors == null) {
            professors = new ArrayList<>();
        }
        professors.add(professor);
    }

    public void removeStudentById(Long id) {
        if (students == null) {
            return;
        }
        for (Students student : students) {
            if (student.getId().compareTo(id) == 0) {
                students.remove(student);
                break;
            }
        }
    }
    public void addStudent(Students student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public String toString() {
        return "{" +
                "id:" + id +
                ",name:" + name +
                ",type:" + type +
                ",year:" + year +
                ",times_per_week:" + times_per_week +
                "}";
    }

    @Override
    public int hashCode()  { return Objects.hash(id); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Courses e = (Courses) o;
        return id.equals(e.id) && name.equals(e.name) && type.equals(e.type) &&
                year.equals(e.year) && times_per_week.equals(e.times_per_week);
    }
}

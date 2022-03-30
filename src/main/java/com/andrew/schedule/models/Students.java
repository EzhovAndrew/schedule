package com.andrew.schedule.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Students {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "year")
    private Long year;
    @Column(name = "student_group")
    private Long group;
    @Column(name = "stream")
    private Long stream;

    @ManyToMany(mappedBy = "students")
    List<Courses> courses;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getGroup() { return group; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPatronymic() { return patronymic; }
    public Long getStream() { return stream; }
    public Long getYear() { return year; }
    public List<Courses> getCourses() { return courses; }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }
    public void setStream(Long stream) { this.stream = stream; }
    public void setYear(Long year) { this.year = year; }
    public void setGroup(Long group) { this.group = group; }

    public Students() {}
    public Students(Long id, String name, String surname, String patronymic, Long year, Long group, Long stream) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.year = year;
        this.group = group;
        this.stream = stream;
    }
    public Students(String name, String surname, String patronymic, Long year, Long group, Long stream) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.year = year;
        this.group = group;
        this.stream = stream;
    }

    public String toString() {
        return "{" +
                "id:" + id +
                ",name:" + name +
                ",surname:" + surname +
                ",patronymic:" + patronymic +
                ",year:" + year +
                ",group:" + group +
                ",stream:" + stream +
                "}";
    }

    @Override
    public int hashCode()  { return Objects.hash(id); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Students e = (Students) o;
        return id.equals(e.id) && name.equals(e.name) && surname.equals(e.surname) &&
                patronymic.equals(e.patronymic) && group.equals(e.group) &&
                stream.equals(e.stream) && year.equals(e.year);
    }
}

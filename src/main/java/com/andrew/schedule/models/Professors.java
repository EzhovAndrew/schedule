package com.andrew.schedule.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "professors")
public class Professors {
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

    @ManyToMany(mappedBy = "professors")
    List<Courses> courses;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPatronymic() { return patronymic; }

    public List<Courses> getCourses() { return courses; }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public Professors() {}
    public Professors(Long id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }
    public Professors(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String toString() {
        return "{" +
                "id:" + id +
                ",name:" + name +
                ",surname:" + surname +
                ",patronymic:" + patronymic +
                "}";
    }

    @Override
    public int hashCode()  { return Objects.hash(id); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Professors e = (Professors) o;
        return id.equals(e.id) && name.equals(e.name) && surname.equals(e.surname) &&
                patronymic.equals(e.patronymic);
    }
}

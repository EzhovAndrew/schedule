package com.andrew.schedule.controllers;

import com.andrew.schedule.dao.StudentsDAO;
import com.andrew.schedule.dao.impl.StudentsDAOImpl;
import com.andrew.schedule.models.Students;
import com.andrew.schedule.views.StudentsView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private final StudentsDAO studentsDAO = new StudentsDAOImpl();

    @GetMapping(value = "/get")
    public List<StudentsView> get(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "patronymic", required = false) String patronymic,
            @RequestParam(name = "group", required = false) Long group,
            @RequestParam(name = "stream", required = false) Long stream
    ) {
        List<StudentsView> students = new ArrayList<>();
        for (Students student : studentsDAO.getByFilter(name, surname, patronymic, group, stream)) {
            students.add(new StudentsView(student));
        }
        return students;
    }

    @PostMapping(value = "add")
    public void add(@RequestBody StudentsView s) {
        Students student = new Students(s.name, s.surname, s.patronymic, s.year, s.group, s.stream);
        studentsDAO.save(student);
    }


    @PostMapping(value = "edit/{id}")
    public void edit(
            @PathVariable Long id,
            @RequestBody StudentsView s
    ) {
        Students student = studentsDAO.getById(id);

        if (s.name != null) {
            student.setName(s.name);
        }
        if (s.surname != null) {
            student.setSurname(s.surname);
        }
        if (s.patronymic != null) {
            student.setPatronymic(s.patronymic);
        }
        if (s.year != null) {
            student.setYear(s.year);
        }
        if (s.group != null) {
            student.setGroup(s.group);
        }
        if (s.stream != null) {
            student.setStream(s.stream);
        }

        studentsDAO.update(student);
    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable Long id) {
        Students student = studentsDAO.getById(id);
        studentsDAO.delete(student);
    }
}

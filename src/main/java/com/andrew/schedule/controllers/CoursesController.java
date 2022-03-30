package com.andrew.schedule.controllers;

import com.andrew.schedule.dao.CoursesDAO;
import com.andrew.schedule.dao.ProfessorsDAO;
import com.andrew.schedule.dao.StudentsDAO;
import com.andrew.schedule.dao.impl.CoursesDAOImpl;
import com.andrew.schedule.dao.impl.ProfessorsDAOImpl;
import com.andrew.schedule.dao.impl.StudentsDAOImpl;
import com.andrew.schedule.models.Courses;
import com.andrew.schedule.models.Professors;
import com.andrew.schedule.models.Students;
import com.andrew.schedule.views.CoursesView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    private final CoursesDAO coursesDAO = new CoursesDAOImpl();
    private final ProfessorsDAO professorsDAO = new ProfessorsDAOImpl();
    private final StudentsDAO studentsDAO = new StudentsDAOImpl();

    @GetMapping(value = "/get")
    public List<CoursesView> get() {
        List<CoursesView> courses = new ArrayList<>();
        for (Courses course : coursesDAO.getAll()) {
            courses.add(new CoursesView(course));
        }
        return courses;
    }

    @PostMapping(value = "/add")
    public void add(@RequestBody CoursesView c) {
        Courses course = new Courses(c.name, c.type, c.year, c.times_per_week);
        coursesDAO.save(course);
        if (c.add_students_ids != null) {
            for (Long id : c.add_students_ids) {
                Students student = studentsDAO.getById(id);
                course.addStudent(student);
            }
        }
        if (c.add_professors_ids != null) {
            for (Long id : c.add_professors_ids) {
                Professors professor = professorsDAO.getById(id);
                course.addProfessor(professor);
            }
        }
        coursesDAO.update(course);
    }


    @PostMapping(value = "/edit/{id}")
    public void edit(
            @PathVariable(name = "id") Long course_id,
            @RequestBody CoursesView coursesView
    ) {
        Courses course = coursesDAO.getById(course_id);

        if (coursesView.name != null) {
            course.setName(coursesView.name);
        }
        if (coursesView.type != null) {
            course.setType(coursesView.type);
        }
        if (coursesView.year != null) {
            course.setYear(coursesView.year);
        }
        if (coursesView.times_per_week!= null) {
            course.setTimes_per_week(coursesView.times_per_week);
        }

        if (coursesView.delete_students_ids != null) {
            for (Long id : coursesView.delete_students_ids) {
                course.removeStudentById(id);
            }
        }
        if (coursesView.delete_professors_ids != null) {
            for (Long id : coursesView.delete_professors_ids) {
                course.removeProfessorById(id);
            }
        }
        if (coursesView.add_students_ids != null) {
            for (Long id : coursesView.add_students_ids) {
                Students student = studentsDAO.getById(id);
                course.addStudent(student);
            }
        }
        if (coursesView.add_professors_ids != null) {
            for (Long id : coursesView.add_professors_ids) {
                Professors professor = professorsDAO.getById(id);
                course.addProfessor(professor);
            }
        }

        coursesDAO.update(course);
    }


    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        Courses course = coursesDAO.getById(id);
        coursesDAO.delete(course);
    }
}

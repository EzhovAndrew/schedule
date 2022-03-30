package com.andrew.schedule.controllers;

import com.andrew.schedule.dao.ClassroomsDAO;
import com.andrew.schedule.dao.CoursesDAO;
import com.andrew.schedule.dao.LessonsDAO;
import com.andrew.schedule.dao.impl.ClassroomsDAOImpl;
import com.andrew.schedule.dao.impl.CoursesDAOImpl;
import com.andrew.schedule.dao.impl.LessonsDAOImpl;
import com.andrew.schedule.models.Classrooms;
import com.andrew.schedule.models.Courses;
import com.andrew.schedule.models.Lessons;
import com.andrew.schedule.utils.TimeConverterUtil;
import com.andrew.schedule.views.LessonsView;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonsController {
    private final LessonsDAO lessonsDAO = new LessonsDAOImpl();
    private final ClassroomsDAO classroomsDAO = new ClassroomsDAOImpl();
    private final CoursesDAO coursesDAO = new CoursesDAOImpl();

    @PostMapping(value = "/add")
    public void add(@RequestBody LessonsView lessonsView) {
        Courses course = coursesDAO.getById(lessonsView.course_id);
        Classrooms classroom = classroomsDAO.getById(lessonsView.classroom_number);

        Lessons lesson = new Lessons();
        lesson.setStart_time(lessonsView.start_time);
        lesson.setClassroom(classroom);
        lesson.setCourse(course);

        lessonsDAO.save(lesson);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        Lessons lesson = lessonsDAO.getById(id);
        lessonsDAO.delete(lesson);
    }

    @GetMapping(value = "/classrooms/get/{classroom_id}")
    public List<LessonsView> getByClassroomAndTime(
            @PathVariable Long classroom_id,
            @RequestParam(name = "startTime") String start_time_str,
            @RequestParam(name = "endTime") String end_time_str)
    {
        LocalDateTime start_time = TimeConverterUtil.fromString(start_time_str);
        LocalDateTime end_time = TimeConverterUtil.fromString(end_time_str);

        Classrooms classroom = classroomsDAO.getById(classroom_id);
        List<LessonsView> lessons = new ArrayList<>();
        for (Lessons lesson: classroom.getLessons()) {
            if (start_time.compareTo(lesson.getStart_time()) < 0 &&
                    lesson.getStart_time().compareTo(end_time) < 0)
            {
                lessons.add(new LessonsView(lesson));
            }
        }
        return lessons;
    }

    @GetMapping(value = "/professors/get/{id}")
    public List<LessonsView> getByProfessorIdAndTime(
            @PathVariable(name = "id") Long professor_id,
            @RequestParam(name = "startTime") String start_time_str,
            @RequestParam(name = "endTime") String end_time_str)
    {
        LocalDateTime start_time = TimeConverterUtil.fromString(start_time_str);
        LocalDateTime end_time = TimeConverterUtil.fromString(end_time_str);

        List<LessonsView> lessons = new ArrayList<>();
        for (Lessons lesson: lessonsDAO.getByProfessorIdAndTime(professor_id, start_time, end_time)) {
                lessons.add(new LessonsView(lesson));
        }
        return lessons;
    }

    @GetMapping(value = "/students/get/{id}")
    public List<LessonsView> getByStudentIdAndTime(
            @PathVariable(name = "id") Long student_id,
            @RequestParam(name = "startTime") String start_time_str,
            @RequestParam(name = "endTime") String end_time_str)
    {
        LocalDateTime start_time = TimeConverterUtil.fromString(start_time_str);
        LocalDateTime end_time = TimeConverterUtil.fromString(end_time_str);

        List<LessonsView> lessons = new ArrayList<>();
        for (Lessons lesson: lessonsDAO.getByStudentIdAndTime(student_id, start_time, end_time)) {
            lessons.add(new LessonsView(lesson));
        }
        return lessons;
    }
}

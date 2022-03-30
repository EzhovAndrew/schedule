package com.andrew.schedule.controllers;

import com.andrew.schedule.models.Classrooms;
import com.andrew.schedule.dao.ClassroomsDAO;
import com.andrew.schedule.dao.impl.ClassroomsDAOImpl;
import com.andrew.schedule.utils.TimeConverterUtil;
import com.andrew.schedule.views.ClassroomView;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassroomsController {
    private final ClassroomsDAO classroomsDAO = new ClassroomsDAOImpl();

    @GetMapping(value = "/get_all")
    public List<ClassroomView> getAll() {
        List<ClassroomView> classrooms = new ArrayList<>();
        for (Classrooms classroom : classroomsDAO.getAll()) {
            classrooms.add(new ClassroomView(classroom));
        }
        return classrooms;
    }

    @GetMapping(value = "/free/get")
    public List<ClassroomView> getByStartTime(
            @RequestParam(name = "startTime") String start_time_str,
            @RequestParam(name = "endTime") String end_time_str
    )
    {
        LocalDateTime startTime = TimeConverterUtil.fromString(start_time_str);
        LocalDateTime endTime = TimeConverterUtil.fromString(end_time_str);

        List<ClassroomView> classrooms = new ArrayList<>();
        for (Classrooms classroom : classroomsDAO.getAllByTime(startTime, endTime)) {
            classrooms.add(new ClassroomView(classroom));
        }

        return classrooms;
    }

    @PostMapping(value = "/add")
    public void add(@RequestBody ClassroomView classroomView) {
        Classrooms classrooms = new Classrooms(classroomView.number, classroomView.capacity);
        classroomsDAO.save(classrooms);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        Classrooms classrooms = classroomsDAO.getById(id);
        classroomsDAO.delete(classrooms);
    }
}

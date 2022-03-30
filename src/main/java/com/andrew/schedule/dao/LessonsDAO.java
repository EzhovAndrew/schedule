package com.andrew.schedule.dao;

import com.andrew.schedule.models.Lessons;

import java.time.LocalDateTime;
import java.util.List;

public interface LessonsDAO {
    void delete(Lessons lesson);
    Lessons getById(Long id);
    List<Lessons> getByProfessorIdAndTime(Long professor_id, LocalDateTime start_time, LocalDateTime end_time);
    List<Lessons> getByStudentIdAndTime(Long student_id, LocalDateTime start_time, LocalDateTime end_time);
    void save(Lessons lesson);

}

package com.andrew.schedule.dao;

import com.andrew.schedule.models.Classrooms;

import java.time.LocalDateTime;

import java.util.List;

public interface ClassroomsDAO {
    void delete(Classrooms classrooms);
    void save(Classrooms classroom);
    List<Classrooms> getAll();
    Classrooms getById(Long id);
    List<Classrooms> getAllByTime(LocalDateTime start_time, LocalDateTime end_time);
}

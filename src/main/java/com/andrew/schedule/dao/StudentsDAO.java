package com.andrew.schedule.dao;

import com.andrew.schedule.models.Students;

import java.util.List;

public interface StudentsDAO {
    Students getById(Long id);
    void delete(Students student);
    void save(Students student);
    void update(Students student);
    List<Students> getByFilter(
            String name,
            String surname,
            String patronymic,
            Long group,
            Long stream
    );
}

package com.andrew.schedule.dao;

import com.andrew.schedule.models.Professors;
import com.andrew.schedule.models.Students;

import java.util.List;

public interface ProfessorsDAO {
    Professors getById(Long id);
    void delete(Professors professor);
    void save(Professors professor);
    void update(Professors professor);
    List<Professors> getByFilter(
            String name,
            String surname,
            String patronymic
    );
}

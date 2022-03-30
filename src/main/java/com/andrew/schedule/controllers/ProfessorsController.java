package com.andrew.schedule.controllers;

import com.andrew.schedule.dao.ProfessorsDAO;
import com.andrew.schedule.dao.impl.ProfessorsDAOImpl;
import com.andrew.schedule.models.Professors;
import com.andrew.schedule.views.ProfessorsView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorsController {
    private final ProfessorsDAO professorsDAO = new ProfessorsDAOImpl();

    @GetMapping(value = "/get")
    public List<ProfessorsView>   get(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "patronymic", required = false) String patronymic
    ) {
        List<ProfessorsView> professors = new ArrayList<>();
        for (Professors professor : professorsDAO.getByFilter(name, surname, patronymic)) {
            professors.add(new ProfessorsView(professor));
        }
        return professors;
    }

    @PostMapping(value = "add")
    public void add(@RequestBody ProfessorsView professorsView) {
        Professors professor = new Professors(professorsView.name, professorsView.surname, professorsView.patronymic);
        professorsDAO.save(professor);
    }


    @PostMapping(value = "edit/{id}")
    public void edit(
            @PathVariable Long id,
            @RequestBody ProfessorsView professorsView
    ) {
        Professors professor = professorsDAO.getById(id);

        if (professorsView.name != null) {
            professor.setName(professorsView.name);
        }
        if (professorsView.surname != null) {
            professor.setSurname(professorsView.surname);
        }
        if (professorsView.patronymic != null) {
            professor.setPatronymic(professorsView.patronymic);
        }

        professorsDAO.update(professor);
    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable Long id) {
        Professors professor = professorsDAO.getById(id);
        professorsDAO.delete(professor);
    }
}

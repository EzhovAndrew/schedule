package com.andrew.schedule.dao.impl;

import com.andrew.schedule.dao.ProfessorsDAO;
import com.andrew.schedule.dao.StudentsDAO;
import com.andrew.schedule.models.Professors;
import com.andrew.schedule.models.Students;
import com.andrew.schedule.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProfessorsDAOImpl implements ProfessorsDAO {
    @Override
    public void save(Professors professor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(professor);
        session.evict(professor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Professors professor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(professor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Professors professor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(professor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Professors getById(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Professors professor = session.get(Professors.class, id);
        session.getTransaction().commit();
        session.close();
        return professor;
    }

    @Override
    public List<Professors> getByFilter(
            String name,
            String surname,
            String patronymic)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Professors> criteriaQuery = builder.createQuery(Professors.class);
        Root<Professors> root = criteriaQuery.from(Professors.class);

        List<Predicate> predicates = new ArrayList<>();
        if (name != null) {
            predicates.add(builder.like(root.get("name"), name));
        }
        if (surname != null) {
            predicates.add(builder.equal(root.get("surname"), surname));
        }
        if (patronymic != null) {
            predicates.add(builder.equal(root.get("patronymic"), patronymic));
        }

        if (predicates.size() > 0) {
            criteriaQuery.where(predicates.toArray(new Predicate[0]));
        }
        List<Professors> professors = session.createQuery(criteriaQuery).list();

        session.getTransaction().commit();
        session.close();
        return professors;
    }
}

package com.andrew.schedule.dao.impl;

import com.andrew.schedule.dao.StudentsDAO;
import com.andrew.schedule.models.Students;
import com.andrew.schedule.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAOImpl implements StudentsDAO {
    @Override
    public void save(Students student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.evict(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Students student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Students student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Students getById(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Students student = session.get(Students.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    @Override
    public List<Students> getByFilter(
            String name,
            String surname,
            String patronymic,
            Long group,
            Long stream)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Students> criteriaQuery = builder.createQuery(Students.class);
        Root<Students> root = criteriaQuery.from(Students.class);

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
        if (group != null) {
            predicates.add(builder.equal(root.get("group"), group));
        }
        if (stream != null) {
            predicates.add(builder.equal(root.get("stream"), stream));
        }

        if (predicates.size() > 0) {
            criteriaQuery.where(predicates.toArray(new Predicate[0]));
        }
        List<Students> students = session.createQuery(criteriaQuery).list();

        session.getTransaction().commit();
        session.close();
        return students;
    }
}

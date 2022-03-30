package com.andrew.schedule.dao.impl;

import com.andrew.schedule.dao.LessonsDAO;
import com.andrew.schedule.utils.HibernateSessionFactoryUtil;
import com.andrew.schedule.models.Lessons;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LessonsDAOImpl implements LessonsDAO {
    @Override
    public void save(Lessons lesson) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(lesson);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Lessons lesson) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(lesson);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Lessons getById(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Lessons lesson = session.get(Lessons.class, id);
        session.getTransaction().commit();
        session.close();
        return lesson;
    }

    @Override
    public List<Lessons> getByProfessorIdAndTime(
            Long professor_id, LocalDateTime start_time, LocalDateTime end_time)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Lessons> criteriaQuery = builder.createQuery(Lessons.class);
        Root<Lessons> root = criteriaQuery.from(Lessons.class);

        criteriaQuery.select(root);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.join("course").join("professors").get("id"), professor_id));
        predicates.add(builder.greaterThan(root.get("start_time"), start_time));
        predicates.add(builder.lessThan(root.get("start_time"), end_time));
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        List<Lessons> classrooms = session.createQuery(criteriaQuery).list();

        session.getTransaction().commit();
        session.close();
        return classrooms;
    }

    @Override
    public List<Lessons> getByStudentIdAndTime(Long student_id, LocalDateTime start_time, LocalDateTime end_time) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Lessons> criteriaQuery = builder.createQuery(Lessons.class);
        Root<Lessons> root = criteriaQuery.from(Lessons.class);

        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.join("course").join("students").get("id"), student_id));
        predicates.add(builder.greaterThan(root.get("start_time"), start_time));
        predicates.add(builder.lessThan(root.get("start_time"), end_time));
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        List<Lessons> classrooms = session.createQuery(criteriaQuery).list();

        session.getTransaction().commit();
        session.close();
        return classrooms;
    }
}

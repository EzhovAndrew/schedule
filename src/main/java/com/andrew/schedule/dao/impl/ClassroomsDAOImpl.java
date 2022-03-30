package com.andrew.schedule.dao.impl;

import com.andrew.schedule.dao.ClassroomsDAO;
import com.andrew.schedule.utils.HibernateSessionFactoryUtil;
import com.andrew.schedule.models.Classrooms;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

public class ClassroomsDAOImpl implements ClassroomsDAO {
    @Override
    public Classrooms getById(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Classrooms classroom = session.get(Classrooms.class, id);
        session.getTransaction().commit();
        session.close();
        return classroom;
    }

    @Override
    public List<Classrooms> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Classrooms> query = session.createQuery("FROM Classrooms", Classrooms.class);
        List<Classrooms> classrooms = query.list();
        session.getTransaction().commit();
        session.close();
        return classrooms;
    }

    @Override
    public List<Classrooms> getAllByTime(LocalDateTime startTime, LocalDateTime endTime) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Classrooms> criteriaQuery = builder.createQuery(Classrooms.class);
        Root<Classrooms> root = criteriaQuery.from(Classrooms.class);

        criteriaQuery.select(root);
        criteriaQuery.where(
            builder.or(
                    builder.greaterThanOrEqualTo(root.join("lessons").get("start_time"), endTime),
                    builder.lessThanOrEqualTo(root.join("lessons").get("start_time"), startTime.minusMinutes(90L))
            )
        ).distinct(true);
        List<Classrooms> classrooms = session.createQuery(criteriaQuery).list();

        session.getTransaction().commit();
        session.close();
        return classrooms;
    }

    @Override
    public void save(Classrooms classroom) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(classroom);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Classrooms classrooms) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(classrooms);
        session.getTransaction().commit();
        session.close();
    }
}

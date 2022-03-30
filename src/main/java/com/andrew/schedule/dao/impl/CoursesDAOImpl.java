package com.andrew.schedule.dao.impl;

import com.andrew.schedule.dao.CoursesDAO;
import com.andrew.schedule.models.Classrooms;
import com.andrew.schedule.models.Courses;
import com.andrew.schedule.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CoursesDAOImpl implements CoursesDAO {
    @Override
    public Courses getById(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Courses course = session.get(Courses.class, id);
        session.getTransaction().commit();
        session.close();
        return course;
    }

    @Override
    public void delete(Courses course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void save(Courses course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(course);
        session.evict(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Courses course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Courses> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Courses> courses = session.createQuery("FROM Courses", Courses.class).list();
        session.getTransaction().commit();
        session.close();
        return courses;
    }
}

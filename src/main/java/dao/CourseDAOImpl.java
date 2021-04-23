package dao;

import model.Course;
import org.hibernate.Session;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Course findById(int id) {
        return session.get(Course.class, id);
    }

    @Override
    public Course save(Course course) {
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();

        return course;
    }

    @Override
    public Course update(Course course) {

        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();

        return course;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Course> findAll() {
        return session.createQuery("from Course").getResultList();
    }

    @Override
    public void deleteById(int id) {
        final Course course = findById(id);
        delete(course);
    }

    @Override
    public void delete(Course course) {
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
    }
}

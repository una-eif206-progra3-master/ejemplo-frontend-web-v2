package dao;

import model.CourseGroup;
import org.hibernate.Session;

import javax.transaction.Transactional;

@Transactional
public class CourseGroupDAOImpl implements CourseGroupDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public CourseGroup findById(int id) {
        return session.find(CourseGroup.class, id);
    }

    @Override
    public CourseGroup save(CourseGroup courseGroup) {
        session.beginTransaction();
        session.save(courseGroup);
        session.getTransaction().commit();
        session.refresh(courseGroup);

        return courseGroup;
    }

    @Override
    public CourseGroup update(CourseGroup courseGroup) {
        session.beginTransaction();
        session.update(courseGroup);
        session.getTransaction().commit();
        session.refresh(courseGroup);

        return courseGroup;
    }

    @Override
    public void delete(CourseGroup courseGroup) {
        session.beginTransaction();
        session.delete(courseGroup);
        session.getTransaction().commit();
    }
}

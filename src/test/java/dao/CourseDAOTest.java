package dao;

import model.Course;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CourseDAOTest {
    final Logger logger = LogManager.getLogger(CourseDAOTest.class);

    private CourseDAO courseDAO;

    @Test
    public void save() {
        Course course = new Course();
        Course courseCreated = null;

        course.setName("Progra 3");
        course.setThematic("About Progra 3");
        course.setStatus(true);

        courseDAO = new CourseDAOImpl();
        courseCreated = courseDAO.save(course);

        assertEquals(courseCreated.getName(), course.getName());
    }

    @Test
    public void findById() {
        Course course = null;
        courseDAO = new CourseDAOImpl();

        course = courseDAO.findById(1);

        assertEquals(course.getName(), "Progra 3");
    }


    @Test
    public void update() {
        Course course;
        Course courseUpdated;
        int idEntity = 3;
        courseDAO = new CourseDAOImpl();

        course = courseDAO.findById(idEntity);
        course.setName("Progra 4");
        courseDAO.update(course);
        courseUpdated = courseDAO.findById(idEntity);

        assertEquals(courseUpdated.getName(), "Progra 4");
    }

    @Test
    public void findAll() {
        List<Course> courseList = null;
        courseDAO = new CourseDAOImpl();
        courseList = courseDAO.findAll();

        assertTrue(courseList.size() > 1);
    }

    @Test
    public void deleteById() {
        Course course;
        int idEntity = 1;
        courseDAO = new CourseDAOImpl();
        courseDAO.deleteById(idEntity);
        course = courseDAO.findById(idEntity);

        assertNull(course);
    }


}

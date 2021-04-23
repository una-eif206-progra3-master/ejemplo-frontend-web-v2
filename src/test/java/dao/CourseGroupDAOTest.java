package dao;

import model.Course;
import model.CourseGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CourseGroupDAOTest {
    final Logger logger = LogManager.getLogger(CourseDAOTest.class);

    private CourseGroupDAO courseGroupDAO;
    private CourseDAO courseDAO;

    @Test
    public void save() {
        CourseGroup courseGroup = new CourseGroup();
        Course course = new Course();
        CourseGroup courseGroupCreated = null;

        course.setName("Progra 3");
        course.setThematic("About Progra 3");
        course.setStatus(true);

        courseDAO = new CourseDAOImpl();
        courseDAO.save(course);

        courseGroup.setCourse(course);
        courseGroup.setSchedule("Mon - Fri");

        courseGroupDAO = new CourseGroupDAOImpl();
        courseGroupCreated = courseGroupDAO.save(courseGroup);

        assertEquals(courseGroupCreated.getSchedule(), "Mon - Fri");
    }

    @Test
    public void update() {
        CourseGroup courseGroup;
        CourseGroup courseGroupUpdated;
        int idEntity = 1;
        courseGroupDAO = new CourseGroupDAOImpl();

        courseGroup = courseGroupDAO.findById(idEntity);
        courseGroup.setSchedule("Thu");
        courseGroupDAO.update(courseGroup);
        courseGroupUpdated = courseGroupDAO.findById(idEntity);

        assertEquals(courseGroupUpdated.getSchedule(), "Thu");
    }

    @Test
    public void delete() {
        CourseGroup courseGroup;
        int idEntity = 1;
        courseGroupDAO = new CourseGroupDAOImpl();

        courseGroup = courseGroupDAO.findById(idEntity);

        courseGroupDAO.delete(courseGroup);

        courseGroup = courseGroupDAO.findById(idEntity);

        assertNull(courseGroup);
    }
}

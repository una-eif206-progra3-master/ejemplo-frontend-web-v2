package service;

import dao.CourseDAO;
import dao.CourseDAOImpl;
import model.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    public CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public Course findById(int id) {
        return courseDAO.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }
}

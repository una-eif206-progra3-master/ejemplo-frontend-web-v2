package service;

import model.Course;

import java.util.List;

public interface CourseService {
    public Course findById (int id);
    public List<Course> findAll ();
    public Course save(Course course);
}

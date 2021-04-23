package dao;

import model.Course;

import java.util.List;

public interface CourseDAO {
    public Course findById (int id);
    public Course save(Course course);
    public Course update(Course course);
    public List<Course> findAll ();
    public void deleteById(int id);
    public void delete(Course course);
}

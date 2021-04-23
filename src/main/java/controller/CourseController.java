package controller;

import model.Course;
import service.CourseService;
import service.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseController", urlPatterns = "/course")
public class CourseController extends HttpServlet {

    private final CourseService courseService = new CourseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseId = request.getParameter("id");
        Course course = null;
        List<Course> courseList = null;
        if (courseId != null) {
            int id = Integer.parseInt(courseId);
            course = courseService.findById(id);
            request.setAttribute("course", course);
        } else {
            courseList = courseService.findAll();
            request.setAttribute("courseList", courseList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/course.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}

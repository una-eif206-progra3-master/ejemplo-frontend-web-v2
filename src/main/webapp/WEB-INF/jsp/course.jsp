<%@ page import="model.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mguzmana
  Date: 4/22/21
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Page</title>
</head>
<body>
    <%
        if (request.getAttribute("course") != null) {
            Course course = (Course) request.getAttribute("course");
    %>
    <h1>Course Details</h1>
    <div>
        <label>ID:</label><span><%= course.getId()%></span>
    </div>
    <div>
        <label>Name:</label><span><%= course.getName()%></span>
    </div>
    <div>
        <label>Status:</label><span><%= course.isStatus()%></span>
    </div>
    <div>
        <label>Thematic:</label><span><%= course.getThematic()%></span>
    </div>
    <%
    }
        else if (request.getAttribute("courseList") != null)
    {
        List<Course> courseList = (List<Course>) request.getAttribute("courseList");
    %>

    <%
    } else {
    %>
        <h1>No course record found.</h1>
            <%
        }
    %>
</body>
</html>

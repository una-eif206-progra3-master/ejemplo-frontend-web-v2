<%@ page import="model.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mguzmana
  Date: 4/22/21
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Course Page</title>
</head>
<body>
<c:if test="${course != null}">
    <h1>Course Details</h1>
    <div>
        <label>ID:</label><span><c:out value='${course.getId()}'/></span>
    </div>
    <div>
        <label>Name:</label><span>${course.getName()}</span>
    </div>
    <div>
        <label>Status:</label><span>${course.isStatus()}</span>
    </div>
    <div>
        <label>Thematic:</label><span>${course.getThematic()}</span>
    </div>
</c:if>

<c:if test="${courseList != null}">
    <h1>Course List</h1>
    <c:forEach items="${courseList}" var="course">
        <div>
            <label>ID:</label><span><c:out value='${course.getId()}'/></span>
        </div>
        <div>
            <label>Name:</label><span>${course.getName()}</span>
        </div>
        <div>
            <label>Status:</label><span>${course.isStatus()}</span>
        </div>
        <div>
            <label>Thematic:</label><span>${course.getThematic()}</span>
        </div>
    </c:forEach>
</c:if>

    <h2>Course Details</h2>
    <form name="courseForm" action="course" method="POST">
        <div>
            <label>Name:</label><span><input type="text" name="name"/></span>
        </div>
        <div>
            <label>Status:</label><span><input type="text" name="status"/></span>
        </div>
        <div>
            <label>Thematic:</label><span><input type="text" name="thematic"/></span>
        </div>
        <div>
            <input type="submit" value="Submit" name="save" /> | <input type="reset" value="Reset" name="reset"/>
        </div>
    </form>

</body>
</html>

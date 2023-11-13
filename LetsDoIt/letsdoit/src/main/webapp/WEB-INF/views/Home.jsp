<!-- Home.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <title>Home Page</title>
</head>

<body>
    <h1>Welcome to the Home Page</h1>
    <h2> Hey, ${user.firstName}</h2> 
    <a href="/tasks/new">Create a Task</a>
    <table>
        <thead>
            <tr>
                <th>Date Posted</th>
                <th>User</th>
                <th>Name</th>
                <th>Due Date</th>
                <th>Priority</th>
                <th>Completion Status</th>
                <th>Comment Count</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <!-- Format the date without the time -->
                    <td>
                        <fmt:formatDate value="${task.createdAt}" pattern="MM/dd/yyyy" var="formattedDate" />
                        ${formattedDate}
                    </td>
                    <td>${task.user.firstName}</td>
                    <td>${task.taskName}</td>
                    <!-- Format the due date without the time -->
                    <td>
                        <fmt:formatDate value="${task.dueDate}" pattern="MM/dd/yyyy" var="formattedDueDate" />
                        ${formattedDueDate}
                    </td>
                    <td>${task.priority}</td>
                    <td>${task.completionStatus}</td>
                    <td>
                        <c:out value="${fn:length(task.comments)}" />
                    </td>
                    <td><a href="/tasks/${task.id}">View</a></td>
                    <td>
                        <c:if test="${userId == task.user.id }">
                            <a href="/tasks/edit/${task.id}"> Edit </a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/logout">Logout</a>
</body>

</html>

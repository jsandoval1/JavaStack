<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <html>

    <head>
        <title>View Task</title>
    </head>

    <body>
        <h1>Task Details</h1>
        <table>
            <tr>
                <th>User</th>
                <td>
                    <c:out value="${task.user.firstName}" />
                    <c:out value="${task.user.lastName}" />
                </td>
            </tr>
            <th>Task Name</th>
            <td>
                <c:out value="${task.taskName}" />
            </td>
            </tr>
            <tr>
                <th>Description</th>
                <td>
                    <c:out value="${task.taskDescription}" />
                </td>
            </tr>
            <tr>
                <th>Due Date</th>
                <td>
                    <c:out value="${task.dueDate}" />
                </td>
            </tr>
            <tr>
                <th>Priority</th>
                <td>
                    <c:out value="${task.priority}" />
                </td>
            </tr>
            <tr>
                <th>Status</th>
                <td>
                    <c:out value="${task.completionStatus}" />
                </td>
            </tr>
            <tr>
                <th>Created At</th>
                <td>
                    <c:out value="${task.createdAt}" />
                </td>
            </tr>
        </table>
        <c:if test="${sessionScope.user.id == task.user.id}">
            <a href="/tasks/edit/${task.id}">Edit Task</a>
            <br>
            <!-- * Button to delete task -->
            <form action="/tasks/delete/${task.id}" method="post">
                <input type="hidden" name="_method" value="delete" />
                <input type="submit" value="Delete Task" />
            </form>
            <br>
        </c:if>
        <a href="/home">Back to home</a>
    </body>

    </html>
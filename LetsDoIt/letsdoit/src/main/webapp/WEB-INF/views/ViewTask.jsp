<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Jstl tag for forms -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <br>

            <h2>Comments</h2>
            <!-- ! New -->
            <!-- Display comments -->
            <c:forEach items="${task.comments}" var="comment">
                <div>
                    <strong>
                        <c:out value="${comment.user.firstName} ${comment.user.lastName} commented:" />
                    </strong>
                    <p>
                        <c:out value="${comment.content}" />
                    </p>
                </div>
            </c:forEach>
            <br>

            <!-- Form to add new comment -->
            <form:form method="POST" action="/comment/new" modelAttribute="comment">
                <!-- Hidden fields for task and user IDs -->
                <input type="hidden" name="taskId" value="${task.id}" />
                <input type="hidden" name="userId" value="${user.id}" />

                <!-- Textarea for comment content -->
                <label for="content">Add a comment:</label>
                <form:textarea path="content" required="true" />
                <form:errors path="content" cssClass="error" />
                <br>

                <!-- Submit button -->
                <input type="submit" value="Submit">
            </form:form>

            <!-- ! End new -->

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
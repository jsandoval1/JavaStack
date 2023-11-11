<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <title>Edit Task</title>
                </head>

                <body>
                    <h1>Edit Task</h1>
                    <form:form method="POST" action="/tasks/edit/${task.id}" modelAttribute="task">
                        <input type="hidden" name="user" value="${userId}">
                        <input type="hidden" name="_method" value="put">

                        <!-- * Task ID (hidden) -->
                        <!-- <input type="hidden" name="taskId" value="${task.id}"> -->

                        <!-- * Created At (hidden) -->
                        <input type="hidden" name="createdAt" value="${task.createdAt}">


                        <!-- * Task Name -->
                        <label for="taskName">Task Name:</label>
                        <form:input path="taskName" required="true" />
                        <form:errors path="taskName" />
                        <br>

                        <!-- * Description -->
                        <label for="taskDescription">Describe the task:</label>
                        <form:input path="taskDescription" required="true" />
                        <form:errors path="taskDescription" />
                        <br>

                        <!-- * Priority -->
                        <label for="priority">Priority:</label>
                        <form:select path="priority">
                            <form:option value="LOW">Low</form:option>
                            <form:option value="MEDIUM">Medium</form:option>
                            <form:option value="HIGH">High</form:option>
                        </form:select>
                        <form:errors path="priority" />
                        <br>

                        <!-- * Completion Status -->
                        <label for="completionStatus">Completion Status:</label>
                        <form:select path="completionStatus">
                            <form:option value="STARTED">Started</form:option>
                            <form:option value="IN_PROGRESS">In Progress</form:option>
                            <form:option value="DONE">Done</form:option>
                        </form:select>
                        <form:errors path="completionStatus" />

                        <!-- * Due Date -->
                        <label for="dueDate">Due Date:</label>
                        <form:input path="dueDate" type="date" required="true" />

                        <!-- * Submit Button -->
                        <input type="submit" value="Update Task">
                    </form:form>
                    <br>
                    <!-- * Button to delete task -->
                    <form:form method="POST" action="/tasks/delete/${task.id}" modelAttribute="task">
                        <input type="hidden" name="user" value="${userId}">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete Task">
                    </form:form>
                    <br>
                    <a href="/home">Back to Tasks</a>
                </body>

                </html>
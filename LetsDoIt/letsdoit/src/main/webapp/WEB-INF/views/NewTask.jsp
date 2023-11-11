<!-- CreateNewBook.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <title>Create New Task</title>
                </head>

                <body>
                    <h1>Create a New Book</h1>
                    <form:form method="POST" action="/tasks/new" modelAttribute="task">
                        <!-- * ⬇️ NEED THIS FOR BOOK TO TIE WITH USER ID ⬇️-->
                        <input type="hidden" name="user" value="${userId}">

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

                        <!-- * Due Date -->
                        <label for="dueDate">Due Date:</label>
                        <form:input path="dueDate" type="date" required="true" />
                        <form:errors path="dueDate" />

                        <!-- *Submit Button -->
                        <input type="submit" value="Add Task" />

                    </form:form>
                    <br>

                    <a href="/home">Go Back</a>
                </body>

                </html>
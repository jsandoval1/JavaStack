<!-- Home.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <!doctype html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <title>LetsDoIt Home</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                    crossorigin="anonymous">
                <style>
                    *{
                        font-family: sans-serif;
                    }

                    .table-row:hover {
                        background-color: #95BCF2 !important;
                    }

                    table {
                        margin: auto;
                        width: 100% !important;
                        max-width: 100% !important;
                        text-align: center;
                    }

                    th {
                        text-align: center;
                    }

                    td {
                        text-align: center;
                    }

                    .nav-link {
                        background-color: #CCCCCC;
                    }

                    .nav-link.active {
                        background-color: #B6D7A8;
                    }

                    th {
                        position: sticky;
                        top: 0;
                        background-color: #fff;
                        /* Set the background color of the fixed header */
                        z-index: 1;
                    }

                    .table-responsive {
                        overflow-y: auto;
                        max-height: 500px;
                        /* Adjust the max-height as needed */
                    }
                </style>
            </head>

            <body style="background-color: gray;">
                <nav class="navbar navbar-expand-lg navbar-dark justify-content-center"
                    style="padding-top: 0.5rem; padding-bottom: 0.5rem; background-color: #6AA84F ;">
                    <div class="container-fluid d-flex justify-content-center mx-auto">
                        <a class="navbar-brand" href="/home">LetsDoIt</a>
                    </div>
                </nav>

                <div class="container-fluid mt-2">
                    <div class="row">

                        <!-- Left NavBar -->
                        <div class="col-md-3" style="padding-right: 0;">
                            <nav class="nav flex-column">
                                <a class="nav-link ${page == 'home' ? 'active' : ''}" href="/home">&#x1F343; Home</a>
                                <a class="nav-link ${page == 'createTask' ? 'active' : ''}" href="/tasks/new">&#127912;
                                    LetsDoPost</a>
                                <!-- <a class="nav-link ${page == 'logout' ? 'active' : ''}" href="#">Logout</a> -->
                                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">&#128488;
                                    LetsDoChat</a>
                                <a class="nav-link ${page == 'logout' ? 'active' : ''}" href="#">&#9881;
                                    LetsDoSettings</a>
                            </nav>
                        </div>

                        <!-- Right Maincontent -->
                        <div class="col-md-9" style="padding-left: 0;">
                            <div style="background-color: #B6D7A8; padding: 1rem;">
                                <div style="display: flex; justify-content: space-between; align-items: center;">
                                    <div>
                                        <h6> Welcome, ${sessionScope.user.firstName}</h6>
                                    </div>
                                    <div>
                                        <h2>LetsDoHub</h2>
                                    </div>
                                    <div>
                                        <h3>WeatherAPI</h3>
                                        <!-- * Add weather API call here -->
                                    </div>
                                </div>
                                <!-- Table -->
                                <div class="table-responsive" style="max-height: 500px; overflow-y: auto;">
                                    <table class="table table-hover" style="border: 1px solid black;">
                                        <thead>
                                            <tr>
                                                <th class="d-none d-md-table-cell" style="background-color: lightgrey;">
                                                    Date Posted</th>
                                                <th style="background-color: lightgrey;">User</th>
                                                <th style="background-color: lightgrey;">Name</th>
                                                <th style="background-color: lightgrey;">Due Date</th>
                                                <!-- <th class="d-none d-md-table-cell" style="background-color: lightgrey;">
                                                    Priority</th> -->
                                                <th style="background-color: lightgrey;">Status</th>
                                                <th class="d-none d-md-table-cell" style="background-color: lightgrey;">
                                                    Comments</th>
                                                <th style="background-color: lightgrey;">Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody id="scroll-table">
                                            <c:forEach items="${tasks}" var="task">
                                                <tr class="table-row">

                                                    <!-- *created date -->
                                                    <td class="d-none d-md-table-cell">
                                                        <fmt:formatDate value="${task.createdAt}" pattern="MM/dd/yy"
                                                            var="formattedDate" />
                                                        ${formattedDate}
                                                    </td>

                                                    <!-- *user first name -->
                                                    <td>${task.user.firstName}
                                                        <c:if test="${userId == task.user.id }">
                                                            <a href="/tasks/edit/${task.id}"
                                                                class="btn btn-warning btn-sm"
                                                                style="display: inline-block;">&#x1F58D;</a>
                                                        </c:if>
                                                    </td>

                                                    <!-- *task name and priority -->
                                                    <td>
                                                        <a href="/tasks/${task.id}">${task.taskName}</a>
                                                        ${task.priority}
                                                    </td>

                                                    <!-- *due date -->
                                                    <td>
                                                        <fmt:formatDate value="${task.dueDate}" pattern="MM/dd/yy"
                                                            var="formattedDueDate" />
                                                        ${formattedDueDate}
                                                    </td>

                                                    <!-- *priority-->
                                                    <!-- <td class="d-none d-md-table-cell">${task.priority}</td> -->

                                                    <!-- *completion status -->
                                                    <td>
                                                        <c:choose>
                                                            <c:when
                                                                test="${task.completionStatus.toString() == 'STARTED'}">
                                                                <span>&#x1F95A;</span> <!-- Egg Emoji-->
                                                            </c:when>
                                                            <c:when
                                                                test="${task.completionStatus.toString() == 'IN_PROGRESS'}">
                                                                <span>&#x1f414;</span> <!-- Chicken Emoji-->
                                                            </c:when>
                                                            <c:when
                                                                test="${task.completionStatus.toString() == 'DONE'}">
                                                                <span>&#x1F357;</span> <!-- Drumstick Emoji-->
                                                            </c:when>
                                                            <c:otherwise>
                                                                ${task.completionStatus}
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>

                                                    <!-- *comment count -->
                                                    <td class="d-none d-md-table-cell">
                                                        <c:out value="${fn:length(task.comments)}" />
                                                    </td>

                                                    <!-- *actions -->
                                                    <td>
                                                        <div class="text-center">
                                                            <a href="/tasks/${task.id}" class="btn btn-primary btn-sm"
                                                                style="display: inline-block;">&#x1F52D;</a>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                                <!-- Button that displays the user in sessions name to create a task -->
                                <div class="text-center mt-3">
                                    <form method="GET" action="/tasks/new">
                                        <input type="hidden" name="user" value="${userId}">
                                        <input type="submit"
                                            value="${sessionScope.user.firstName}, LetsDoSomethingNew &#x1F95A;"
                                            class="btn btn-success" style="background-color: #6AA84F;">
                                    </form>
                                </div>
                            </div>
            </body>

            </html>
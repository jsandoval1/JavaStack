<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>LetsView ${task.taskDescription}</title>
                    <!-- Link to js file -->
                    <script src="/js/quote.js"></script>
                    <!-- Link to css file -->
                    <link rel="stylesheet" href="/css/style.css">

                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                        crossorigin="anonymous">
                </head>

                <body style="background-color: gray;">

                    <header class="navbar navbar-expand-lg navbar-dark justify-content-center"
                        style="padding-top: 0.5rem; padding-bottom: 0.5rem; background-color: #6AA84F ;">
                        <div class="container-fluid d-flex justify-content-center mx-auto">
                            <a class="navbar-brand" href="/home">LetsDoIt &#127793;</a>
                        </div>
                    </header>

                    <div class="content-container">
                        <div class="container-fluid mt-2">
                            <div class="row">

                                <!-- Left NavBar -->
                                <div class="col-md-3" style="padding-right: 0;">
                                    <nav class="nav flex-column">
                                        <a class="nav-link" href="/home">&#x1F343; Home</a>
                                        <a class="nav-link" href="/tasks/new">&#127912; LetsDoPost</a>
                                        <a class="nav-link disabled" href="#" >&#128488; LetsDoChat</a>
                                        <a class="nav-link" href="#">&#9881; LetsDoSettings</a>
                                        <a class="nav-link" href="/logout">&#128694;Logout</a>
                                    </nav>
                                </div>
                                
                                <!-- Right Maincontent -->
                                <div class="col-md-9" style="padding-left: 0;">
                                    <div style="background-color: #B6D7A8; padding: 1rem;">
                                        <div style="display: flex; justify-content: center; align-items: center;">
                                            <h2>LetsView</h2>
                                        </div>

                                        <div class="card">
                                            <div class="card-header">
                                                Task Details
                                            </div>
                                            <div class="card-body">
                                                <h5 class="card-title">
                                                    <c:out value="${task.taskName}" />
                                                </h5>
                                                <h6 class="card-subtitle mb-2 text-muted">
                                                    <c:out value="${task.user.firstName}" />
                                                    <c:out value="${task.user.lastName}" />
                                                </h6>
                                                <p class="card-text">
                                                    <c:out value="${task.taskDescription}" />
                                                </p>
                                                <ul class="list-group list-group-flush">
                                                    <li class="list-group-item">
                                                        <strong>Due Date:</strong>
                                                        <fmt:formatDate value="${task.dueDate}" pattern="MM/dd/yyyy"
                                                            var="formattedDate" />
                                                        ${formattedDate}
                                                    </li>
                                                    <li class="list-group-item">
                                                        <strong>Priority:</strong>
                                                        <c:choose>
                                                            <c:when test="${task.priority.toString() == 'LOW'}">
                                                                <span>&#x1F7E2; Low priority</span>
                                                                <!-- Green Square Emoji-->
                                                            </c:when>
                                                            <c:when test="${task.priority.toString() == 'MEDIUM'}">
                                                                <span>&#x1F7E1; Medium Priority</span>
                                                                <!-- Yellow Square Emoji-->
                                                            </c:when>
                                                            <c:when test="${task.priority.toString() == 'HIGH'}">
                                                                <span>&#x1F7E0; High Priority</span>
                                                                <!-- Red Square Emoji-->
                                                            </c:when>
                                                        </c:choose>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <strong>Status:</strong>
                                                        <c:choose>
                                                            <c:when
                                                                test="${task.completionStatus.toString() == 'STARTED'}">
                                                                <span>&#x1F95A; Starting out</span> <!-- Egg Emoji-->
                                                            </c:when>
                                                            <c:when
                                                                test="${task.completionStatus.toString() == 'IN_PROGRESS'}">
                                                                <span>&#x1f414; Working through it</span>
                                                                <!-- Chicken Emoji-->
                                                            </c:when>
                                                            <c:when
                                                                test="${task.completionStatus.toString() == 'DONE'}">
                                                                <span>&#x1F357; Its done for</span>
                                                                <!-- Drumstick Emoji-->
                                                            </c:when>
                                                            <c:otherwise>
                                                                ${task.completionStatus}
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <strong>Uploaded At:</strong>
                                                        <fmt:formatDate value="${task.createdAt}" pattern="MM/dd/yyyy"
                                                            var="formattedDate" />
                                                        ${formattedDate} ,
                                                        <fmt:formatDate value="${task.createdAt}" pattern="hh:mm:ss a"
                                                            var="formattedTime" />
                                                        ${formattedTime}
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-between mt-1">
                                            <c:if test="${sessionScope.user.id == task.user.id}">
                                                <a href="/tasks/edit/${task.id}" class="btn btn-success"
                                                    style="background-color: #6AA84F;">&#x1F58D; Edit Task</a>
                                                    <form action="/tasks/delete/${task.id}" method="post">
                                                        <input type="hidden" name="_method" value="delete" />
                                                        <input type="submit" value=" &#x1f5d1; Delete Task" class="btn btn-danger" />
                                                    </form>
                                            </c:if>
                                        </div>
                                        <br>

                                        <h4>Comments (
                                            <c:out value="${fn:length(task.comments)}" />)
                                        </h4>
                                        <!-- Display comments -->
                                        <c:forEach items="${task.comments}" var="comment">
                                            <div class="card mb-3">
                                                <div class="card-header">
                                                    <strong>
                                                        <c:out
                                                            value="${comment.user.firstName} ${comment.user.lastName}" />
                                                        said:
                                                    </strong>
                                                    <div>
                                                        <p class="card-text">
                                                            <fmt:formatDate value="${comment.createdAt}"
                                                                pattern="MM/dd/yyyy" var="formattedDate" />
                                                            ${formattedDate} ,

                                                            <fmt:formatDate value="${comment.createdAt}"
                                                                pattern="hh:mm:ss a" var="formattedTime" />
                                                            ${formattedTime}
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="card-body">
                                                    <p class="card-text">
                                                        <c:out value="${comment.content}" />
                                                    </p>
                                                </div>
                                                <div class="card-footer text-muted">
                                                    <c:if test="${sessionScope.user.id == comment.user.id}">
                                                        <form action="/comment/delete/${comment.id}" method="post">
                                                            <input type="hidden" name="_method" value="delete" />
                                                            <button type="submit" class="btn btn-danger"> &#x1f5d1;
                                                                Delete
                                                                Comment</button>
                                                        </form>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </c:forEach>

                                        <!-- Form to add new comment -->
                                        <form:form method="POST" action="/comment/new" modelAttribute="comment"
                                            class="mt-4">
                                            <!-- Hidden fields for task and user IDs -->
                                            <input type="hidden" name="taskId" value="${task.id}" />
                                            <input type="hidden" name="userId" value="${user.id}" />

                                            <!-- Textarea for comment content -->
                                            <div class="form-group">
                                                <label for="content">Add a comment:</label>
                                                <form:textarea path="content" required="true"
                                                    class="form-control text-muted" rows="3"
                                                    placeholder="${sessionScope.user.firstName}, what do you think?" />
                                                <form:errors path="content" cssClass="error" />
                                            </div>

                                            <div class="text-center">
                                                <!-- Submit button -->
                                                <button type="submit" class="btn btn-primary mt-1 align-content-center">
                                                    &#128488;Submit</button>
                                            </div>
                                        </form:form>


                                    </div>
                                </div>
                            </div>

                </body>

                </html>
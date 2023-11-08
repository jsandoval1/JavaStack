<!-- UserAuth.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--! c:out ; c:forEach etc. -->
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!--! Formatting (dates) -->
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!--! form:form -->
                <%@ page isErrorPage="true" %> <!--! for rendering errors on PUT routes -->
                    <!DOCTYPE html>
                    <html data-bs-theme="dark">

                    <head>
                        <meta charset="UTF-8">
                        <title>LogItIn!</title>
                        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
                        <link rel="stylesheet" href="/css/main.css">
                        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
                        <script type="text/javascript" src="/js/app.js"></script>
                    </head>

                    <body>
                        <div class="container">

                            <!--? REGISTER FORM -->
                            <h2 class="display-1">Registration</h2>
                            <div class="card shadow">
                                <div class="card-body">
                                    <form:form action="/register" method="post" modelAttribute="newUser">
                                        <!--* User name field with label, input paths and errors -->
                                        <div class="mb-3">
                                            <form:label class="form-label" path="userName">user name</form:label>
                                            <form:input class="form-control" path="userName"></form:input>
                                            <form:errors class="form-text text-danger" path="userName"></form:errors>
                                        </div>
                                        <!--* Email field with label, input paths and errors -->
                                        <div class="mb-3">
                                            <form:label class="form-label" path="email">email</form:label>
                                            <form:input class="form-control" path="email"></form:input>
                                            <form:errors class="form-text text-danger" path="email"></form:errors>
                                        </div>
                                        <!--* Password field with label, input paths and errors -->
                                        <div class="mb-3">
                                            <form:label class="form-label" path="password">password</form:label>
                                            <form:input class="form-control" path="password"></form:input>
                                            <form:errors class="form-text text-danger" path="password"></form:errors>
                                        </div>
                                        <!--* Confirm password field with label, input paths and errors -->
                                        <div class="mb-3">
                                            <form:label class="form-label" path="confirm">confirm password</form:label>
                                            <form:input class="form-control" path="confirm"></form:input>
                                            <form:errors class="form-text text-danger" path="confirm"></form:errors>
                                        </div>
                                        <input class="btn btn-primary" type="submit" value="register">
                                    </form:form>
                                </div>
                            </div>
                            <!--? LOGIN FORM -->
                            <h2 class="display-1">Login</h2>
                            <div class="card shadow">
                                <div class="card-body">
                                    <form:form action="/login" method="post" modelAttribute="newLogin">
                                        <!-- ! Input to validate email using newLogin attribute -->
                                        <div class="mb-3">
                                            <form:label class="form-label" path="email">email</form:label>
                                            <form:input class="form-control" path="email"></form:input>
                                            <form:errors class="form-text text-danger" path="email"></form:errors>
                                        </div>
                                        <!--! Input to validate password using newLogin attribute -->
                                        <div class="mb-3">
                                            <form:label class="form-label" path="password">password</form:label>
                                            <form:input class="form-control" path="password"></form:input>
                                            <form:errors class="form-text text-danger" path="password"></form:errors>
                                        </div>
                                        <input class="btn btn-primary" type="submit" value="login">
                                    </form:form>
                                </div>
                            </div>
                        </div>

                    </body>

                    </html>
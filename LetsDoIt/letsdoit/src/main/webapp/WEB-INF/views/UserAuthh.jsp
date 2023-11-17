<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--! c:out ; c:forEach etc. -->
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!--! Formatting (dates) -->
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!--! form:form -->
                <%@ page isErrorPage="true" %> <!--! for rendering errors on PUT routes -->
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <meta charset="UTF-8">
                        <title>LetsLogIn</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
                            rel="stylesheet"
                            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                            crossorigin="anonymous">
                        <style>
                            .card {
                                padding: 0.5rem;
                                margin: 5rem;
                                border: 4px solid #6AA84F;
                            }

                            h2 {
                                text-align: center;
                            }
                        </style>
                    </head>

                    <body style="background-color: #666666;">
                        <header class="navbar navbar-expand-lg navbar-dark justify-content-center"
                            style="padding-top: 0.5rem; padding-bottom: 0.5rem; background-color: #6AA84F ;">
                            <div class="container-fluid d-flex justify-content-center mx-auto">
                                <a class="navbar-brand" href="/home">LetsDoIt &#127793;</a>
                            </div>
                        </header>
                        <div class="d-flex justify-content-center">
                            <div class="card mx-5" style="background-color: #999999;">
                                <!-- Login Form -->
                                <div>
                                    <fieldset>
                                        <legend><b>Login</b></legend>
                                        <form:form action="/login" method="post" modelAttribute="newLogin">
                                            <div class="mt-3">
                                                <form:input class="form-control" path="email"
                                                    placeholder="Enter your email"></form:input>
                                                <form:errors class="form-text text-danger" path="email"></form:errors>
                                            </div>
                                            <div class="mt-3">
                                                <form:input class="form-control" path="password"
                                                    placeholder="Enter your password"></form:input>
                                                <form:errors class="form-text text-danger" path="password">
                                                </form:errors>
                                            </div>
                                            <div class="mt-3 d-flex justify-content-center">
                                                <input type="submit" value="Login" class="btn btn-success"
                                                    style="background-color: #6AA84F;">
                                            </div>
                                        </form:form>
                                    </fieldset>
                                </div>
                            </div>
                            <div class="card mx-5" style="background-color: #999999;">
                                <!-- Register Form -->
                                <div>
                                    <fieldset>
                                        <legend><b>Register</b></legend>
                                        <form:form action="/register" method="post" modelAttribute="newUser">
                                            <div class="mt-3">
                                                <form:input class="form-control" path="firstName"
                                                    placeholder="Enter your first name"></form:input>
                                                <form:errors class="form-text text-danger" path="firstName">
                                                </form:errors>
                                            </div>
                                            <div class="mt-3">
                                                <form:input class="form-control" path="lastName"
                                                    placeholder="Enter your last name"></form:input>
                                                <form:errors class="form-text text-danger" path="lastName">
                                                </form:errors>
                                            </div>
                                            <div class="mt-3">
                                                <form:input class="form-control" path="email"
                                                    placeholder="Enter your email"></form:input>
                                                <form:errors class="form-text text-danger" path="email"></form:errors>
                                            </div>
                                            <div class="mt-3">
                                                <form:input class="form-control" path="password"
                                                    placeholder="Enter your password"></form:input>
                                                <form:errors class="form-text text-danger" path="password">
                                                </form:errors>
                                            </div>
                                            <div class="mt-3">
                                                <form:input class="form-control" path="confirm"
                                                    placeholder="Confirm your password"></form:input>
                                                <form:errors class="form-text text-danger" path="confirm"></form:errors>
                                            </div>
                                            <div class="mt-3 d-flex justify-content-center">
                                                <input type="submit" value="Register" class="btn btn-success"
                                                    style="background-color: #6AA84F;">
                                            </div>
                                        </form:form>
                                    </fieldset>
                                </div>
                            </div>
                    </body>

                    </html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Dojo Details</title>
        </head>

        <body>
            <h1>Dojo Details</h1>
            <h2>${dojo.name}</h2>
            <p>Ninjas:</p>
            <table>
                <thead>
                    <th>Ninja First Name</th>
                    <th>Ninja Last Name</th>
                    <th>Ninja Age</th>
                </thead>
                <tbody>
                    <c:forEach items="${dojo.ninjas}" var="ninja">
                        <tr>
                            <td>
                                <!--  * C outs needed to render data from DB -->
                                <c:out value="${ninja.firstName}"></c:out>
                            </td>
                            <td>
                                <c:out value="${ninja.lastName}"></c:out>
                            </td>
                            <td>
                                <c:out value="${ninja.age}"></c:out>
                            </td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </body>

        </html>
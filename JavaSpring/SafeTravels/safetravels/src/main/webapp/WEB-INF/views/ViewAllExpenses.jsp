<!-- JSP page to show table with all expenses -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Expenses</title>
                    <link rel="stylesheet" type="text/css" href="css/expenses.css">
                </head>

                <body>
                    <h1>Save Travels</h1>
                    <h2>Test to see if page is updated</h2>
                    <!-- Table to loop over our expenses -->
                    <table>
                        <thead>
                            <tr>
                                <th>Expense</th>
                                <th>Vendor</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="expenses" items="${expenses}">
                                <tr>
                                    <!-- Making the exepense name a link to the expense detail page, @GetMapping("/expenses/{id}")  -->
                                    <td><a href="/expenses/${expenses.id}">${expenses.expenseName}</a></td>
                                    <td>${expenses.expenseVendor}</td>
                                    <td>$${expenses.expenseAmount}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <!-- ! NEED TO CREATE FORM TO ADD MORE EXPENSES TMW -->
                </body>

                </html>
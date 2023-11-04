<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Safe Travels Expenses</title>
    <link rel="stylesheet" type="text/css" href="css/expenses.css">
</head>

<body>
    <h1>Safe Travels Expenses</h1>
    <table>
        <thead>
            <tr>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="expense" items="${expenses}">
                <tr>
                    <td><a href="/expenses/${expense.id}">${expense.expenseName}</a></td>
                    <td>${expense.expenseVendor}</td>
                    <td>$${expense.expenseAmount}</td>
                    <td><a href="/expenses/${expense.id}/edit">Edit</a></td>
                    <!-- delete button disguised as a post form button because http only knows post and get -->
                    <td><form:form method="POST" action="/expenses/${expense.id}/delete">
                        <input type="hidden" name="_method" value="delete" />
                        <input type="submit" value="Delete" />
                    </form:form></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h1>Add an Expense</h1>
    <form:form method="POST" action="/expenses" modelAttribute="expense">
        <label for="expenseName">Expense Name</label>
        <form:input path="expenseName" id="expenseName" required="true" />
        <form:errors path="expenseName" />

        <label for="expenseVendor">Vendor</label>
        <form:input path="expenseVendor" id="expenseVendor" required="true" />
        <form:errors path="expenseVendor" />

        <label for="expenseAmount">Amount</label>
        <form:input path="expenseAmount" id="expenseAmount" required="true" />
        <form:errors path="expenseAmount" />

        <input type="submit" value="Add Expense" />
    </form:form>
</body>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Edit Expenses</title>
                    <link rel="stylesheet" type="text/css" href="css/expenses.css">
                </head>

                <body>
                    <h1>Edit Expenses</h1>
                    <!-- form to update the expense -->
                    <form:form modelAttribute="expense" method="POST" action="/expenses/${expense.id}" >
                        <input type="hidden" name="_method" value="put" />
                
                        <label for="expenseName">Expense Name:</label>
                        <form:input path="expenseName" id="expenseName" required="true" />
                        <form:errors path="expenseName" />
                
                        <label for="expenseVendor">Vendor:</label>
                        <form:input path="expenseVendor" id="expenseVendor" required="true" />
                        <form:errors path="expenseVendor" />
                
                        <label for="expenseAmount">Amount: $</label>
                        <form:input path="expenseAmount" id="expenseAmount" required="" />
                        <form:errors path="expenseAmount" />

                        <button type="submit">Update Expense</button>

                    </form:form>
                </body>

                </html>
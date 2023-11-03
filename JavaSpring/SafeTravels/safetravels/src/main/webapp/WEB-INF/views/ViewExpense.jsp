<!-- JSP page to view an expense detail -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>
                ${expense.expenseName}
            </title>
            <link rel="stylesheet" type="text/css" href="css/expenses.css">
        </head>

        <body>
            <h1>Expense Detail</h1>
            <!-- <h2>Test to see if page is updated</h2> -->
            <h2>${expense.expenseName}</h2>
            <p>Vendor: ${expense.expenseVendor}</p>
            <p>Amount: $${expense.expenseAmount}</p>
            <p>Created at: ${expense.createdAt}</p>
        </body>
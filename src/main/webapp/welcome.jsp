<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.lang.Object" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
</head>

<body>
    <h1><%
        Object username = request.getSession().getAttribute("username");
        if (username == null) {
            out.println("Who are you?");
        } else {
            out.println("Welcome! " + username);
        }
    %></h1>
    <div>
        <button onclick="window.location.href='/IDEA_WebProject/logout';">
            注销
        </button>
    </div>
</body>

</html>
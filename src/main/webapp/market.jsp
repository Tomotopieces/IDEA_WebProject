<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="io.tomoto.util.CookieUtil" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>market</title>
</head>

<body>
    <div>
        <a href="/IDEA_WebProject/goods?name=heart9"><img src="resources/poker/Heart9.png"/> </a><br/>
        <font>红桃9</font>
    </div>
    <div>
        <a href="/IDEA_WebProject/goods?name=heart10"><img src="resources/poker/Heart10.png"/> </a><br/>
        <font>红桃10</font>
    </div>
    <div>
        <a href="/IDEA_WebProject/goods?name=heartJack"><img src="resources/poker/HeartJack.png"/> </a><br/>
        <font>红桃J</font>
    </div>
    <div>
        <a href="/IDEA_WebProject/goods?name=heartQ"><img src="resources/poker/HeartQueen.png"/> </a><br/>
        <font>红桃Q</font>
    </div>
    <div>
        <a href="/IDEA_WebProject/goods?name=heartK"><img src="resources/poker/HeartKing.png"/> </a><br/>
        <font>红桃K</font>
    </div>
    <div>
        <a href="/IDEA_WebProject/goods?name=heartA"><img src="resources/poker/HeartAce.png"/> </a><br/>
        <font>红桃A</font>
    </div>
    <div>
        您浏览过的商品:
        <%
            Cookie[] cookies = request.getCookies();
            Cookie cookie = CookieUtil.findCookie("goods", cookies);
            if (cookie != null) {
                String str = cookie.getValue();
                String[] list = str.split("&");
                request.setAttribute("list", list);
                // request.setAttribute("str", str);
            }
        %>
        <!-- ${str} -->
        <c:forEach items="${list}" var="item">
            - ${item} <br>
        </c:forEach>
        <!-- ... -->
    </div>
</body>

</html>
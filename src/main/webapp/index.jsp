<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="io.tomoto.entity.Person" %>
<%@ page import="io.tomoto.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<html>

<head>
    <style>
        * {
            margin: 0;
        }

        .content {
            width: 800px;
            margin: 0 auto;
            margin-top: 20px;
            padding: 10px;
            border-left: dashed 1px #3D3D3D;
            background-color: #EEEEEE;
        }
    </style>
</head>

<body>
    <%
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Tomoto1", "fanqie", 21, "13218067153"));
        users.add(new User(2, "Tomoto2", "fanqie", 21, "13218067153"));
        users.add(new User(3, "Tomoto3", "fanqie", 21, "13218067153"));
        users.add(new User(4, "Tomoto4", "fanqie", 21, "13218067153"));
        users.add(new User(5, "Tomoto5", "fanqie", 21, "13218067153"));
        request.setAttribute("users", users);
    %>

    <div class="content">
        c:forEach : <br>
        <c:forEach items="${users}" var="user">
            - ${user} <br>
        </c:forEach>
    </div>

    <%
        Person person = new Person();
        person.setName("Tomoto");
        person.setPhones(new String[]{"123", "456", "789"});
        List<String> cities = new ArrayList<>();
        cities.add("Beijing");
        cities.add("Shanghai");
        cities.add("Guangzhou");
        cities.add("Shenzhen");
        person.setCities(cities);
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        person.setMap(map);
        pageContext.setAttribute("p", person);
    %>

    <div class="content">
        ${p} <br>
    </div>

    <div class="content">
        name: ${p.name} <br>
        phones: [${p.phones[0]}, ${p.phones[1]}, ${p.phones[2]}]<br>
        cities: ${p.cities} <br>
        map: ${p.map} <br>
    </div>
    <div class="content">
        1. server name: ${pageContext.request.serverName} <br>
        2. sesrver port: ${pageContext.request.serverPort} <br>
        3. project path: ${pageContext.request.contextPath} <br>
    </div>
    
    <!-- scope: scope | var: name | value: value -->
    <div class="content">
        c:set : <br>
        <c:set scope="session" var="abc" value="abcValue" />
        abc: ${sessionScope.abc}
    </div>

    <!-- test: condition -->
    <div class="content">
        c:if true: <c:if test="${true}">
            <div>
                true
            </div>
        </c:if>
        c:if false: <c:if test="${false}">
            <div>
                false
            </div>
        </c:if>
    </div class="content">

    <div class="content">
        c:choose: <br>
        <% request.setAttribute("val", 8); %>
        <c:choose>
            <c:when test="${val > 11}">
                val > 11
            </c:when>
            <c:when test="${val > 10}">
                val > 10
            </c:when>
            <c:when test="${val > 9}">
                val > 9
            </c:when>
            <c:when test="${val > 8}">
                val > 8
            </c:when>
            <c:otherwise>
                val &lt;= 8
            </c:otherwise>
        </c:choose>
    </div>

    <div class="content">
        c:forEach i: <br>
        <c:forEach begin="1" end="3" var="i">
            - ${i} <br>
        </c:forEach>
    </div>

    <div class="content">
        c:forEach array: <br>
        <% request.setAttribute("arr", new String[]{"aa", "bb", "cc"}); %>
        <c:forEach items="${arr}" var="item">
            - ${item} <br>
        </c:forEach>
    </div>
</body>

</html>
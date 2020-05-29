<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/26/2020
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>

<c:out value="${result}"></c:out>

<c:choose>
    <c:when test="${exception eq 'a'}">
        <p>loi chia cho 0</p>
    </c:when>
</c:choose>


</body>
</html>

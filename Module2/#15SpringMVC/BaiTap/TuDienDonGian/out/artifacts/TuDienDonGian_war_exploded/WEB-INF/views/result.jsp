<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2020
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="word eq 'khong tim thay tu'"></c:when>
    <c:otherwise>
        <c:out value="${word}"></c:out>
    </c:otherwise>
</c:choose>

</body>
</html>

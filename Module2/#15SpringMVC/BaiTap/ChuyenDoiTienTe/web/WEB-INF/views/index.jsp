<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2020
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>result</title>
</head>
<body>
USD  : <c:out value="${value}"></c:out><br>
Rate : <c:out value="${rate}"></c:out><br>
VND  : <c:out value="${result}"></c:out>
</body>
</html>

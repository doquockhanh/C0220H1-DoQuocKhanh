<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2020
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <form action="/calculate">
    <input type="text" name="firstNum" placeholder="number">
    <input type="text" name="secondNum" placeholder="number"><br>
    <input type="submit" name="operator" value="add">
    <input type="submit" name="operator" value="sub">
    <input type="submit" name="operator" value="mul">
    <input type="submit" name="operator" value="div">
  </form><br>

  First number : <c:out value="${firstNum}"/><br>
  Second number: <c:out value="${secondNum}"/><br>
  Operator     : <c:out value="${operator}"/><br><br>
  <h3>  Result       :
    <c:if test="${result ne ''}">
      <c:out value="${result}"/>
    </c:if>
  </h3>

  </body>
</html>

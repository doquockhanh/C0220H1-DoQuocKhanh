<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2020
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<form action="result", method="post">
    <input type="text" name="inputValue"/>
    <select name="typeConvert">
        <option value="23000">USD->VND: 1/23000</option>
    </select>
    <button type="submit">Convert</button>
</form>
</body>
</html>

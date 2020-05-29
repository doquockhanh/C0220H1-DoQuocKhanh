<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/25/2020
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<form action="/calculating" , method="post">

  <input type="text" name="firstOperand" placeholder="first operand"/> <br>
  <input type="text" name="secondOperand" placeholder="second operand"/> <br>
  <select name="operator">
    <option value="add" >Add ( + )</option>
    <option value="sub">Sub ( - )</option>
    <option value="mul">Mul ( * )</option>
    <option value="div">Div ( / )</option>
  </select>
  <button type="submit">Calculate</button>

</form>
</body>
</html>

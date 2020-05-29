<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/22/2020
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>dictionary</title>
  </head>
  <body>
  <form action="/translate", method="post">
    <select name="input">
      <option name="hello">hello</option>
      <option name="how">how</option>
      <option name="book">book</option>
      <option name="computer">computer</option>
    </select>
    <button type="submit">translate</button>
  </form>
  </body>
</html>

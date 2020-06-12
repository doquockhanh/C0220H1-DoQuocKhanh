<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/31/2020
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>welcome!</title>
  </head>
  <body>
  <h2>Sandwich Condiments</h2>
  <br>
  <form action="/save" method="post">
    <input type="checkbox" name="condiments" value="Lettuce"/> Lettuce
    <input type="checkbox" name="condiments" value="Tomato"/> Tomato
    <input type="checkbox" name="condiments" value="Mustard"/> Mustard
    <input type="checkbox" name="condiments" value="Sprouts"/> Sprouts
    <button type="submit">Save</button>
  </form>

  Result : ${result}
  </body>
</html>

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
  <form action="save", method="get">
    <input type="checkbox" name="Condiments" value="lettuce"> Lettuce <br>
    <input type="checkbox" name="Condiments" value="tomato"> Tomato <br>
    <input type="checkbox" name="Condiments" value="mustard"> Mustard <br>
    <input type="checkbox" name="Condiments" value="sprouts"> Sprouts <br>
    <hr>
    <button>save</button>
  </form>

  </body>
</html>

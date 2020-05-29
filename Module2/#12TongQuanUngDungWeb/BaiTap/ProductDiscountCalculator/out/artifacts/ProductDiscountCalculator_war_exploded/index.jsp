<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/24/2020
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>

  <form action="CalculateDiscount", method="post">
    <input type="text" name="price" placeholder="produce price"/>
    <p></p>
    <input type="text" name="discountPercent" placeholder="Discount Percent"/>
    <p></p>
    <button type="submit">Calculate Discount</button>
  </form>

  </body>
</html>

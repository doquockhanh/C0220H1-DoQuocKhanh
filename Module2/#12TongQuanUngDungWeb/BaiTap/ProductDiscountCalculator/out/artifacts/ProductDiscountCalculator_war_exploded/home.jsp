<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/24/2020
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

Price : <%=request.getParameter("price")%> <br>
DiscountPercent :<%=request.getParameter("discountPercent")%> <br>
Result : <%=Integer.parseInt(request.getParameter("price"))
        - Integer.parseInt(request.getParameter("price"))*Integer.parseInt(request.getParameter("discountPercent"))*0.01%>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/22/2020
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<p>
    So tien nhap : <%=request.getParameter("SoTienNhap")%> $
</p>
<p>
    So tien chuyen doi : <%=Integer.parseInt(request.getParameter("SoTienNhap"))*23000%>
</p>
<p>
    Ti le chuyen doi : 23000
</p>
</body>
</html>

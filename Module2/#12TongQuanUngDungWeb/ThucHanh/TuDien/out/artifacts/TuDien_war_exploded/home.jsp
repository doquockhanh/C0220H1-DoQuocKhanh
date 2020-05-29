<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/24/2020
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p id="result"></p>
<script>
    let a = "<%= request.getParameter("input") %>";
    if( a === "hello"){
        alert("xin chao")
    }else if (a === "how"){
        alert("the nao")
    }else if(a === "computer"){
        alert(a === "may tinh")
    }else if (a === "book"){
        alert("sach")
    }else alert("khong the dich tu nay")
</script>
</body>
</html>

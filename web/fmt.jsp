<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 月冷婷
  Date: 2018/11/28
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
=================fmt:formatDate====================<br>
-- dateStyle="long"默认为long<br>
<fmt:formatDate value="<%=new Date()%>"/><br>
<fmt:formatDate value="<%=new Date()%>" dateStyle="short"/><br>
<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd HH:mm:ss"/><br>
=============================================================<br>
<fmt:formatNumber value="1224" type="currency"></fmt:formatNumber><br>
<fmt:formatNumber value="1224" type="percent"></fmt:formatNumber><br>


</body>
</html>

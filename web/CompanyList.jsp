<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.project.service.ICompanyService" %>
<%@ page import="com.project.service.imp.CompanyServiceImpl" %>
<%@ page import="com.project.model.Company" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/14 0014
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示页面</title>
    <%
        ICompanyService  companyService = new CompanyServiceImpl();
        String Index1 = request.getParameter("Index1");
        String Index;
        Integer pageIndex=1;
        Integer  pageSize=10;

        if(Index1==null){
             Index=request.getParameter("pageIndex");

            if(Index==null){
                pageIndex=1;
            }else {
                pageIndex=Integer.parseInt(Index);
            }

        }else {
            pageIndex=Integer.parseInt(Index1.trim());

        }
        int count = companyService.getCount();
        Integer pageCount=(count%pageSize)==0?count/pageSize:(count/pageSize+1);
        List<Company> companys = companyService.getPages(pageIndex,pageSize);



    %>
</head>
<body>
<center>公司展示页面</center>
<table border="1px" width="100%">
    <tr >
        <td>公司编号</td>
        <td>职位名</td>
        <td>公司名</td>
        <td>公司地点</td>
        <td>其他操作</td>
    </tr>
    <%
        for(int i=0;i<companys.size();i++){
            %>
            <tr>
                <td><%=companys.get(i).getCid()%></td>
                <td><%=companys.get(i).getZwName()%></td>
                <td><%=companys.get(i).getcName()%></td>
                <td><%=companys.get(i).getCplace()%></td>
                <td><a href="#">增加</a> | <a href="delete.jsp?cid=<%=companys.get(i).getCid()%>">删除</a> | <a href="#">修改</a> |<a href="#">查询</a> </td>
            </tr>
        <%
        }
     %>

<c:forEach items="${company}" var="company">

    <tr>
        <td>${company.cid}</td>
        <td>${company.zwName}</td>
        <td>${company.cName}</td>
        <td>${company.cplace}</td>
        <td>
        <td><a href="#">增加</a> | <a href="delete.jsp?cid=${company.cid}">删除</a> | <a href="#">修改</a> |<a href="#">查询</a> </td>
        </td>

    </tr>

</c:forEach>





</table>
<center>共有<%=count%>条记录   <%=pageIndex%>/<%=pageCount%>页
        <a href="CompanyList.jsp?pageIndex=1">首页</a>
        <%
            if(pageIndex>1){
                %>
    <a href="CompanyList.jsp?pageIndex=<%=pageIndex-1%>">上一页</a>
    <%
            }
        %>


    <%
        if(pageIndex<pageCount){
            %>
    <a href="CompanyList.jsp?pageIndex=<%=pageIndex+1%>">下一页</a>
    <%
        }
    %>
    <a href="CompanyList.jsp?pageIndex=<%=pageCount%>">最后一页</a>

</center>
<center>
    <form action="CompanyList.jsp" method="post">
        跳转到<input type="text" name="Index1">
        <input type="submit" value="GO">
    </form>
</center>

<%--<center><jsp:include page="test.jsp"></jsp:include></center>
<iframe src="http://baidu.com"/>--%>
<%--<center><%@include file="test.jsp"%></center>--%>

</body>
</html>

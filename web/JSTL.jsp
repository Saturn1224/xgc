<%--
  Created by IntelliJ IDEA.
  User: 月冷婷
  Date: 2018/11/27
  Time: 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@  page import="com.project.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
-----------------------out-------------------------<br>
直接显示出value的值<br>
default当value的值不存在的时候显示<br>
<c:out default="人类对象不存在"  value="${p}" ></c:out><br>
escapeXml="true";不帮助我们解析,即写出原内容的字符<br>
escapeXml="false";帮助我们解析html<br>
<c:out value="<a href='http://baidu.com'> 点我去百度</a>" escapeXml="false"> </c:out><br>
------------------------------set-----------------------------------<br>
<c:set var="num" value="1000"></c:set>
<c:out value="${num}"></c:out>
${num}<br>
<%
    Person p=new Person();
    request.setAttribute("p",p);
%>
scope:声明变量的作用域<br>
target:声明变量的目标对象<br>
property:声明对象的属性<br>

<c:set target="${p}" value="老李" property="name" ></c:set>
<br>
<c:out value="${p}"></c:out><br>


=====================c:forEach==================<br>
<%
    Person p1=new Person(1,"laoli");
    Person p2=new Person(2,"laoc");
    Person p3=new Person(1,"laot");
    Person p4=new Person(1,"laor");
    List<Person> personList=new ArrayList<Person>();
    personList.add(p1);
    personList.add(p2);
    personList.add(p3);
    personList.add(p4);
    request.setAttribute("personList",personList);




%>
<c:forEach begin="1" end="10" step="1" var="i">
${i}
</c:forEach><br>

items:集合对象(使用EL获取)  varStatus:当前循环的状态信息 ,如索引的序列号<br>
<c:forEach var="people" items="${personList}" varStatus="status">
当前对象:${people}
当前下标:${status.index}
<br>
</c:forEach>

----------使用foreach实现隔行变色--------------
<%
    List<String> heroList=new ArrayList<String>();
    heroList.add("1");
    heroList.add("2");
    heroList.add("3");
    heroList.add("4");
    request.setAttribute("heroList",heroList);
%>
<table border="1px">
    <c:forEach items="${heroList}" var="hero" varStatus="status">
        <tr bgcolor=${status.index%2==0?"red":"green"}>
            <td>${hero}</td>
        </tr>
    </c:forEach>

</table>
====================九九乘法表=======================<br>

<c:forEach var="i" begin="1" end="9">
     <c:forEach var="j" begin="1" end="${i}">
     ${i}*${j}=${i*j}
     </c:forEach>
     <br>
</c:forEach>

=============if================================<br>
<c:if test="${2>1}">
  2>1
</c:if><br>
================url==========================<br>
<c:url value="http://www.baidu.com"  var="baidu"></c:url>
<a href="${baidu}">跳转到百度</a>
<br>
======================param=====================<br>

==================import=======================<br>
直接在页面中添加其他的页面 ,引入页面的地址
<c:import url="http://www.baidu.com"></c:import>








</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 月冷婷
  Date: 2018/11/27
  Time: 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.project.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person=new Person(12,"saturn");
    pageContext.setAttribute("person",person);
    List<Person> arr=new ArrayList<Person>();
    Person person1=new Person(12,"sa");
    Person person2=new Person(13,"sat");
    Person person3=new Person(15,"satu");
    arr.add(person);
    arr.add(person1);
    arr.add(person2);
    arr.add(person3);
    request.setAttribute("myarr",arr);

    String num1="ab";
    String num2="cd";
    request.setAttribute("num11",num1);
    request.setAttribute("num22",num2);


%>
-----------EL取值--------------
<br>
cookie:${Cookie}
<br>
${initParam}
<br>
${1 eq 1}
----------------------------------
<br>
${num11.equals(num22)}
<br>
${1>0?"哈哈":"嘻嘻"}
<br>
<input type="text" value=${false?1:0}>
<br>



${person}
<br>
${person.name}
<br>
${person.id}
<br>
${myarr}
<br>
${myarr[0]}

</body>
</html>

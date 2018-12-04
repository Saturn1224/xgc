<%@ page import="com.project.model.Company" %>
<%@ page import="com.project.dao.ICompanyDao" %>
<%@ page import="com.project.dao.imp.CompanyDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/14 0014
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String cid = request.getParameter("cid");
    ICompanyDao companyDao = new CompanyDaoImpl();
    //类型转换
    int i = Integer.parseInt(cid);
    companyDao.deleteByCid(i);
    response.sendRedirect("CompanyList.jsp");
%>

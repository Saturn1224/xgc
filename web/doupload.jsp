<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.FileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/21 0021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //判断表单是否是post  和enctype="multipart/form-data"
    boolean multipartContent = ServletFileUpload.isMultipartContent(request);
    if(multipartContent){
        //申明对象
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析请求
        List<FileItem> fileItems = upload.parseRequest(request);
        System.out.println("表单元素："+fileItems.size());
        for(FileItem fileItem:fileItems){
            if(!fileItem.isFormField()){
                File  file = new File("D:/"+fileItem.getName());
                fileItem.write(file);


        }else {
            request.getParameter(fileItem.getFieldName());
         }
        }


    }
%>

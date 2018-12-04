package com.saturn.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

@MultipartConfig
public class UploadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Part file = req.getPart("file");
//        String header = file.getHeader("content-disposition");
//        file.write("D:/project2");
//        sub(header);
//        System.out.println(header);
        //多文件
        Collection<Part> parts=req.getParts();
        for (Part part:parts) {
            String header = part.getHeader("content-disposition");
            sub(header);
            part.write("D：/project2");
        }
    }
    public String sub(String str){
        String[] splits=str.split("=");
        int start=splits[2].indexOf("\"");
        int end=splits[2].lastIndexOf("\"");
        return splits[2].substring(start+1,end);
    }
}

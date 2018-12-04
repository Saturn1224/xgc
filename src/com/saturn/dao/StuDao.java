package com.saturn.dao;

public class StuDao implements IStudentDao {
    public String LoginByStudent(String username,String pwd){
        String sql="select * from student where username=? and pwd=?";
  return null;
    }
}

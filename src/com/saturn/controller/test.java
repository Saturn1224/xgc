package com.saturn.controller;

public class test {
    public String sub(String str){
        String[] splits=str.split("=");
        int start=splits[2].indexOf("\"");
        int end=splits[2].lastIndexOf("\"");
        return splits[2].substring(start+1,end);
    }


}

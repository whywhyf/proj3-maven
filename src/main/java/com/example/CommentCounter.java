package com.example;

public class CommentCounter extends Counter{

    public boolean isBlock = false;

    public boolean isComment(String line){
        if(isBlock){
            if(line.endsWith("*/")) isBlock = false;
            return true;
        } 
        if(line.matches("\s*//.*")) return true;
        if(line.matches("^\s*/\\*.*")){
            isBlock = true;
            if(line.endsWith("*/")) isBlock = false;
            return true;
        }
        return false;
    }
}

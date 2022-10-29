package com.example;

public class CommentCounter extends Counter{

    public boolean shouldCount(String line){
        if(line.isBlank() || line.isEmpty()) return false;
        if(line.matches("\s*//.*")) return true;
        if(isBlock || line.matches("^\s*/\\*.*")){
            if(line.matches("^\s*/\\*.*")) isBlock = true;
            if(line.contains("*/")) isBlock = false;
            line = line.replaceFirst(".*\\*/", "");
            line = line.replaceAll("\\\\\\\\", "");
            line = line.replaceAll("\\\\\"", "");
            line = line.replaceAll("\"[^\"]*\"", "");
            line = line.replaceAll("/\\*.*\\*/", "");
            if(line.contains("/*")) isBlock = true;
            return true;
        } 
        line = line.replaceAll("\\\\\\\\", "");
        line = line.replaceAll("\\\\\"", "");
        line = line.replaceAll("\"[^\"]*\"", "");
        line = line.replaceAll("/\\*.*\\*/", "");
        if(line.contains("/*")) isBlock = true;
        return false;
    }



}

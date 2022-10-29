package com.example;

public class CodeCounter extends Counter{

    public boolean shouldCount(String line){
        if(line.isBlank() || line.isEmpty()) return false;
        if(isBlock || line.matches("^\s*/\\*.*")){
            if(line.matches("^\s*/\\*.*")) isBlock = true;
            if(line.contains("*/")) isBlock = false;
            line = line.replaceFirst(".*\\*/", "");
            line = line.replaceAll("\\\\\\\\", "");
            line = line.replaceAll("\\\\\"", "");
            line = line.replaceAll("\"[^\"]*\"", "");
            line = line.replaceAll("/\\*.*\\*/", "");
            if(line.contains("/*")) isBlock = true;
            return false;
        }                
        line = line.replaceAll("\\\\\\\\", "");
        line = line.replaceAll("\\\\\"", "");
        line = line.replaceAll("\"[^\"]*\"", "");
        line = line.replaceAll("/\\*.*\\*/", "");
        if(line.contains("/*")) isBlock = true;
        if(!line.matches("^\s*//.*") && !line.matches("^\s*/\\*.*") ) return true; 
        return false;
    }      
}

package com.example;

public class CodeCounter extends Counter{

    public boolean isCode(String line){
        if(line.isBlank() || line.isEmpty()) return false;
        //if(line.matches(".*\\*/\s*$")) return false;
        if(!line.matches("^\s*//.*") && !line.matches("^\s*/\\*.*") ) return true; 
        return false;
    }
}

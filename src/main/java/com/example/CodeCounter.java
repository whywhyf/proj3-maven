package com.example;

public class CodeCounter extends Counter{
    
    public boolean isCode(String line){
        if(line.matches("\s*\n")) return true;
        return false;
    }
}

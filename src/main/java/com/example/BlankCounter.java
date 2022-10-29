package com.example;

public class BlankCounter extends Counter {

    public boolean shouldCount(String line){
        if(line.matches("\s*")) return true;
        return false;
    }     
}

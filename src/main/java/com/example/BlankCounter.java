package com.example;

public class BlankCounter extends Counter {

    public boolean isBlank(String line){
        if(line.matches("\s*")) return true;
        return false;
    }
}

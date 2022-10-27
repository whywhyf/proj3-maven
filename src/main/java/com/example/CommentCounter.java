package com.example;

public class CommentCounter extends Counter{
    
    public boolean isComment(String line){
        if(line.matches("\s*\n")) return true;
        return false;
    }
}

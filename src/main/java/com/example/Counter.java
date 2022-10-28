package com.example;

import java.io.*;
import java.util.ArrayList;

public class Counter {

    protected int number = 0;//number of count
    protected boolean isBlock = false;//comment block
    protected ArrayList<String> pathlist = new ArrayList<>();
    protected File dir = null; 


    //set path
    public void set_path(ArrayList<String> path_list){
        pathlist = path_list;
    }


    //set number
    protected void set_num(int input){
        number = input;
    }


    //number+1
    protected void add_num(){
        number += 1;
    }

    
    //get number
    protected int get_num(){
        return number;
    }
}

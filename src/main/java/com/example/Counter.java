package com.example;

public class Counter {

    protected int number = 0;//number of count

    //set number
    protected void set_num(int input){
        number = input;
    }

    //number+1
    protected void add_num(){
        number += 1;
    }

    //get number
    public int get_num(){
        return number;
    }
}

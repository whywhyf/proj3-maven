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


    //this will be overrided
    protected boolean shouldCount(String line){
        return true;
    }


    //execute counting
    public void playCount(){
        try{
            for(String path : pathlist){
                dir = new File(path);
                System.out.println(dir);
                if (dir.isDirectory()) {
                    String[] children = dir.list();
                    for (int i = 0; i < children.length; i++) {
                        File dirset = new File(dir, children[i]);
                        System.out.println(dirset);
                        BufferedReader br = new BufferedReader(new FileReader(dirset));
                        String line;
                        while ((line = br.readLine())!=null) {//judge    
                            if(shouldCount(line)) number++; 
                        }
                        br.close();
                        System.out.println("Codes:"+number);
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }     
    }   
}

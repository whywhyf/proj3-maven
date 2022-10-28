package com.example;

import java.io.*;

public class CommentCounter extends Counter{

    public boolean isComment(String line){
        if(isBlock){
            if(line.endsWith("*/")) isBlock = false;
            return true;
        } 
        if(line.matches("\s*//.*")) return true;
        if(line.matches("^\s*/\\*.*")){
            isBlock = true;
            if(line.endsWith("*/")) isBlock = false;
            return true;
        }
        
        return false;
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
                        while ((line = br.readLine())!=null) {//judge comment    
                            if(isComment(line)) number++; 
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

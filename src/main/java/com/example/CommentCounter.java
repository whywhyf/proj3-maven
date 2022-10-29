package com.example;

import java.io.*;

public class CommentCounter extends Counter{

    public boolean isComment(String line){
        if(line.isBlank() || line.isEmpty()) return false;
        if(line.matches("\s*//.*")) return true;
        if(isBlock || line.matches("^\s*/\\*.*")){
            if(line.matches("^\s*/\\*.*")) isBlock = true;
            if(line.contains("*/")) isBlock = false;
            line = line.replaceFirst(".*\\*/", "");
            line = line.replaceAll("\\\\\\\\", "");
            line = line.replaceAll("\\\\\"", "");
            line = line.replaceAll("\"[^\"]*\"", "");
            line = line.replaceAll("/\\*.*\\*/", "");
            if(line.contains("/*")) isBlock = true;
            return true;
        } 
        line = line.replaceAll("\\\\\\\\", "");
        line = line.replaceAll("\\\\\"", "");
        line = line.replaceAll("\"[^\"]*\"", "");
        line = line.replaceAll("/\\*.*\\*/", "");
        if(line.contains("/*")) isBlock = true;
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

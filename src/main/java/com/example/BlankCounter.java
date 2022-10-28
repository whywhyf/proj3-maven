package com.example;

import java.io.*;

public class BlankCounter extends Counter {

    public boolean isBlank(String line){
        if(line==null || line.matches("\s*")) return true;
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
                        while (true) {//judge blank
                            line = br.readLine();
                           if(isBlank(line)) number++;
                           if(line==null) break;    
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

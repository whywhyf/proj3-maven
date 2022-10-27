package com.example;

import java.io.*;

public class Main {

    private File dir; 

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("");

        Main main = new Main();
        main.setPath();
        main.playCount();
        
    }


    //set file path
    public void setPath(){
        dir = new File("src\\main\\java\\com\\example"); 
    }


    //execute counting
    public void playCount(){

        BlankCounter blankCounter = new BlankCounter();
        CodeCounter codeCounter = new CodeCounter();
        CommentCounter commentCounter = new CommentCounter();
        
        try{
            System.out.println(dir);
            if (dir.isDirectory()) {
                String[] children = dir.list();
                for (int i = 0; i < children.length; i++) {
                    File dirset = new File(dir, children[i]);
                    System.out.println(dirset);
                    BufferedReader br = new BufferedReader(new FileReader(dirset));
                    String line;
                    while ((line=br.readLine())!=null) {//judge blank,code,comment
                        if(blankCounter.isBlank(line)) blankCounter.add_num();
                        else if(codeCounter.isCode(line)) codeCounter.add_num();
                        else if(commentCounter.isComment(line)) commentCounter.add_num();
                    }
                    br.close();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        //print result
        System.out.println(blankCounter.get_num());
    }   
}

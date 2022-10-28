package com.example;

import java.io.*;

public class Main {

    private File dir; 
    private BlankCounter blankCounter = new BlankCounter();
    private CodeCounter codeCounter = new CodeCounter();
    private CommentCounter commentCounter = new CommentCounter();


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("");

        Main main = new Main();
        main.setPath();
        main.playCount();
        main.printResult();
    }


    //set file path
    public void setPath(){
        dir = new File("src\\main\\java\\com\\example"); 
    }


    //execute counting
    public void playCount(){
        try{
            System.out.println(dir);
            if (dir.isDirectory()) {
                String[] children = dir.list();
                for (int i = 0; i < children.length; i++) {
                    File dirset = new File(dir, children[i]);
                    System.out.println(dirset);
                    BufferedReader br = new BufferedReader(new FileReader(dirset));
                    String line;
                    while (true) {//judge blank,code,comment
                        line = br.readLine();
                        if(blankCounter.isBlank(line)) blankCounter.add_num(); 
                        else{
                            if(codeCounter.isCode(line) && !commentCounter.isBlock) codeCounter.add_num();
                            if(commentCounter.isComment(line)) commentCounter.add_num();
                        }
                        if(line==null) break;    
                    }
                    br.close();
                    System.out.println("Codes:"+codeCounter.get_num());
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }     
    }   


    //print result
    public void printResult(){
        System.out.println("");
        System.out.println("Blanks:"+blankCounter.get_num());
        System.out.println("Comments:"+commentCounter.get_num());
        System.out.println("Codes:"+codeCounter.get_num());

    }
}

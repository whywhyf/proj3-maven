package com.example;

import java.util.ArrayList;

public class Main {

    private ArrayList<String> pathlist = new ArrayList<>(); 
    private BlankCounter blankCounter = new BlankCounter();
    private CodeCounter codeCounter = new CodeCounter();
    private CommentCounter commentCounter = new CommentCounter();


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("");

        Main main = new Main();
        main.addPath();
        
        main.blankCounter.playCount();
        main.codeCounter.playCount();
        main.commentCounter.playCount();
        main.printResult();
    }


    //add path
    public void addPath(){
        pathlist.add("src\\main\\java\\com\\example");
        pathlist.add("src\\test\\java\\com\\example");

        blankCounter.set_path(pathlist);
        codeCounter.set_path(pathlist);
        commentCounter.set_path(pathlist);
    }


    //print result
    public void printResult(){
        System.out.println("");
        System.out.println("Blanks:"+blankCounter.get_num());
        System.out.println("Comments:"+commentCounter.get_num());
        System.out.println("Codes:"+codeCounter.get_num());

    }
}

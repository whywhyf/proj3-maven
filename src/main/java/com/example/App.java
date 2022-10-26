package com.example;

import java.io.*;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("");
        File dir = new File("src\\main\\java\\com\\example"); //
        visitAllDirsAndFiles(dir);
       
        /*
         * 
         * try{
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            StringBuffer sb;
            while (in.ready()) {
                sb = (new StringBuffer(in.readLine()));
                System.out.println(sb);
            }
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }
         * 
         */
        

        //BlankCounter bcounter = new BlankCounter();
        //bcounter.count();
    }

    public static void visitAllDirsAndFiles(File dir) {
        System.out.println(dir);
        try{
            BufferedReader br = new BufferedReader(new FileReader(dir));
            String line;
            while ((line=br.readLine())!=null) {
                System.out.println(line);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                visitAllDirsAndFiles(new File(dir, children[i]));
            }
        }
    }
}

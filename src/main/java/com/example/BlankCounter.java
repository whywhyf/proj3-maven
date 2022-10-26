package com.example;

import java.io.*;

public class BlankCounter extends Counter {

    public void count(){
        try{
            String dir = "./APP.java";
            File file = new File(dir);
            //如果文件不存在，创建文件
            if (!file.exists()) System.out.println("doesnt exist");
            
            //创建BufferedWriter对象并向文件写入内容
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            //向文件中写入内容
            bw.write("the second way to write and read");
            bw.flush();
            bw.close();
            //创建BufferedReader读取文件内容
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line=br.readLine())!=null) {
                System.out.println(line);
            }
            br.close();
        }
        catch(Exception ex){
            System.out.println("wrong");
        }
    }   
}

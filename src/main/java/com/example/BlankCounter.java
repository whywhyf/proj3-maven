package com.example;

import java.io.*;

public class BlankCounter extends Counter {

    public void count(){
        try{
            String dir = "./APP.java";
            File file = new File(dir);
            //����ļ������ڣ������ļ�
            if (!file.exists()) System.out.println("doesnt exist");
            
            //����BufferedWriter�������ļ�д������
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            //���ļ���д������
            bw.write("the second way to write and read");
            bw.flush();
            bw.close();
            //����BufferedReader��ȡ�ļ�����
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

package com.xyy.io_db_thread.utils;

import java.io.*;

public class ReadFileDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("C:\\Users\\晨科信息\\Desktop\\backup\\map.xlsx");
        FileOutputStream out = new FileOutputStream("");
        int data = in.read();
        System.out.println(data);
//        while (data!=-1){
//            System.out.println(data);
//        }

        in.close();

        File file =new File("C:\\Users\\晨科信息\\Desktop\\backup\\map.xlsx");

    }
}

package com.lxy11.drbox.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpiderName {
    public String test(String param){
        String line = "";
        String lines = "" ;
        String name = "";
        String price = "";
        try{
            //System.out.println("start");
            Process pr = Runtime.getRuntime().exec("python C:\\Users\\xingyi\\PycharmProjects\\class2\\jd.py jd "+param);

            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream(),"GBK"));

            while ((line = in.readLine()) != null) {
                lines += line ;
                //System.out.println(line);
            }
            in.close();
            pr.waitFor();
            //System.out.println("end");
        } catch (Exception e){
            e.printStackTrace();
        }
        name = lines.substring(lines.indexOf("text\">")+6,lines.lastIndexOf("</span"));
        price = lines.substring(lines.lastIndexOf(": ")+2,lines.lastIndexOf("}")-1);
        return name;
    }

//    public static void main(String[] a) {
//        Test5 test5 = new Test5();
//        String res = test5.test("https://item.m.jd.com/product/11918999.html") ;
//        System.out.println(res);
//    }
}
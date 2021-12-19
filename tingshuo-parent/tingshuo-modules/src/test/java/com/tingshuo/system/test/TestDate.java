package com.tingshuo.system.test;

import org.skyscreamer.jsonassert.JSONParser;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 类文件描述:
 * 相关日期格式处理
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月18日 8:59
 **/
public class TestDate {
    public static void main(String[] args) {
        String dateOld="2021-06-01";
        String dateNew="2022-07-02";
        String fra="01";
        String fraOne="01,02,05,03,21,10,18,04";
        String fraTwo="01,02,05,03,-1,04,15,19,04";
        String fraS="-1,01,02,05,03,-2,04,15,14,12";
        String fraF="01,02,05,03,-2,15,14,10,02,02";
        String fraOld="01,02,-1";
        //首次判断 下次传出的数据长度
        if (dateNew.length()>=10){
            //
            String substring = dateNew.substring(5, dateNew.length());
            System.out.println(substring+"===");
            String mm = substring.substring(0,2);
            System.out.println("月"+mm);
            String m = mm.substring(0, 1);
            System.out.println("m单个月="+m);
            if ("0".equals(m)){
                System.out.println("说明有可能：1月2月3月4月5月6月7月8月9月");
                //m.substring()
                String d = substring.substring(2, 5);
                System.out.println("md单个日"+d);
                if ("-1".equals(d)){

                    System.out.println("说明是28、29");
                }if ("-2".equals(d)){
                    System.out.println("说明是有可能是29、或30");
                }
            }else {
                System.out.println("说明是：10 月或者11月或者12月");
            }

        }
        System.out.println("开始计算fre存值");
        String z="";
        //String[] split = fraOne.split(",");
        //String[] split = fraTwo.split(",");
        //String[] split = fraS.split(",");
        String[] split = fraF.split(",");
        Arrays.sort(split);
        List<String> strings = Arrays.asList(split);
        if (strings.contains("-1")&&strings.contains("-2")){
            System.out.println("既有-1，又有-2");
            String s = strings.toString();
            System.out.println(s+"=");
            String substring = s.substring(1, s.length() - 1);
            System.out.println(substring+"-");
            String substring1 = substring.substring(0,6);
            System.out.println(substring1);//说明是28-或者29
            String substring2 = substring.substring(7);
            System.out.println(substring2);
             z= substring2+","+substring1;
            System.out.println(z+"既有-1 ===-2");
        }else if (strings.contains("-1")){
            System.out.println("有-1");
            String s = strings.toString();
            System.out.println(s+"=");
            String substring = s.substring(1, s.length() - 1);
            System.out.println(substring+"-");
            //-1, 01, 02, 03, 05
            String substring1 = substring.substring(0,2);
            System.out.println(substring1+"@@@@@@");//说明是28-或者29
            String substring2 = substring.substring(strings.size()-1);//重点
            System.out.println(substring2+"!!!!");
             z= substring2+","+substring1;
            System.out.println(z+"最后-1");
        }else if (strings.contains("-2")){
            System.out.println("有-2");
            String s = strings.toString();
            System.out.println(s+"=");
            String substring = s.substring(1, s.length() - 1);
            System.out.println(substring+"-");
            String substring1 = substring.substring(0,2);
            System.out.println(substring1+"//说明是28-或者29");//说明是28-或者29
            String substring2 = substring.substring(strings.size()-1);
            System.out.println(substring2);
             z= substring2+","+substring1;
            System.out.println(z+"最后-2");
        }else {
            System.out.println("没有-1，-2");
            String s = strings.toString();
            System.out.println(s+"=");
            String substring = s.substring(1, s.length() - 1);
            System.out.println(substring+"-");

            String substring1 = substring.substring(0,2);
            System.out.println(substring1+"没有-1和-2");
        }
        System.out.println("===================");

    }
    public static List<String> DateUtils(List<String>  data){
//        String[] split = data.split(",");
//        Arrays.sort(split);
//        List<String> list =new ArrayList(Arrays.asList(data));
        HashSet set= new HashSet(data);
        data.clear();
        data.addAll(set);
        System.out.println(data+"22222");
        Collections.sort(data);
        System.out.println(data+"lits1112222222224444444442");
        return data;
    }
}

package com.tingshuo.system.test;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月18日 12:13
 **/
public class DateUtils {
    String d="2021-01-01";

    public static void main(String[] args) {
        String date="2021-08-12";
       //String fraF="01,02,05,03,21,10,18,04";
        //String fraF="01,02,05,03,-1,04,15,19,04";
        String fraF="01,02,05,03,-2,04,15,14,12,-2,-1";
        //String fraF="01,02,05,03,01,01,-2,15,14,10,02,02,-1";
        if (date.length()>=10){
            String m = date.substring(5,7);
            System.out.println(m+"MMM");
            int i = Integer.parseInt(m);
            System.out.println(i+"月份");
            String[] split = fraF.split(",");
            System.out.println(fraF+"月份fraF");
            if (i==2){
                System.out.println(i+"月份"+fraF);
                //Arrays.sort(split);
                List<String> strings = Arrays.asList(split);//转list

                System.out.println("原始数据"+strings);
                System.out.println("原始数据"+split);

                String Data="";
                if (strings.contains("-1")&&strings.contains("-2")){
                    System.out.println("既有-1，又有-2");
                    String replace = strings.toString().replace("-1", "28");
                    Data =replace.replace("-2", "27");
                    System.out.println(Data+"1111111");

                }else if (strings.contains("-1")){
                    System.out.println("有-1");
                    Data=strings.toString().replace("-1","28");
                }else if  (strings.contains("-2")){
                    System.out.println("有-2");
                    Data=strings.toString().replace("-2", "27");
                }else {

                    System.out.println(strings+"000000说明没有-1和 -2");
                    Data = strings.toString();
                }
                System.out.println(Data+"最终");

                String substring = Data.substring(0, Data.length() - 1);
                String substring1 = substring.substring(1);
                System.out.println(substring1+"++++");

                String[] split1 = substring1.split(",");
                List <String> list = new ArrayList<>();
                for (String s : split1) {
                    list.add(s.trim());
                }
                List<String> ss = TestDate.DateUtils(list);
                System.out.println(ss+"SSSSSS");

            }else{

                    System.out.println(i+"月份"+fraF);
                    //Arrays.sort(split);
                    List<String> strings = Arrays.asList(split);//转list

                    System.out.println("原始数据"+strings);
                    String Data="";
                    if (strings.contains("-1")&&strings.contains("-2")){
                        System.out.println("既有-1，又有-2");
                        String replace = strings.toString().replace("-1", "30");
                        Data =replace.replace("-2", "29");
                        System.out.println(Data+"1111111");

                    }else if (strings.contains("-1")){
                        System.out.println("有-1");
                        Data=strings.toString().replace("-1","30");
                    }else if  (strings.contains("-2")){
                        System.out.println("有-2");
                        Data=strings.toString().replace("-2", "29");
                    }else {

                        System.out.println(strings+"000000说明没有-1和 -2");
                         Data = strings.toString();

                    }
                    System.out.println(Data+"最终");

                    String substring = Data.substring(0, Data.length() - 1);
                    String substring1 = substring.substring(1);
                    System.out.println(substring1+"++++");

                    String[] split1 = substring1.split(",");
                    List <String> list = new ArrayList<>();
                    for (String s : split1) {
                        list.add(s.trim());
                    }
                    List<String> ss = TestDate.DateUtils(list);
                    System.out.println(ss+"SSSSSS");

                }

        }
    }

}

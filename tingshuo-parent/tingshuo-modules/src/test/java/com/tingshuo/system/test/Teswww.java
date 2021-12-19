package com.tingshuo.system.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月18日 19:02
 **/
public class Teswww {
    public static void main(String[] args) {
        String dateOld = "2021-12-02";
        String dataoldNew = "2021-12-05";
        String oldDat="[01,02,05,06,07,09,10]";
        String substring = oldDat.substring(0, oldDat.length() - 1);
        String substring1 = substring.substring(1);
        List<String> list = new ArrayList<>();

        list.add(substring1);
        System.out.println("数据库值是="+list);

        String dOld = dateOld.substring(8, 10);//老的日期
        String dNew = dataoldNew.substring(8, 10);//新的日期

        String mOld = dateOld.substring(5, 7);//旧的月
        String mNew = dataoldNew.substring(5, 7);//新的月

        String yOld = dateOld.substring(0, 4); //老的年
        String yNew = dataoldNew.substring(0, 4);//新的年

        System.out.println("之前的年="+yOld);
        System.out.println("新跑的年="+yNew);
            System.out.println("新数据的日="+dNew);
            //步骤1.判断日期，是否再第一次执行日期范围中，不在直接跳出本次任务
            // 步骤2.日期在范围内，判断月是否一致，一致执行。不一致，直接跳出
            //步骤3.如果是 新数据月是02月-27 ，28对应旧的数据日期，是1月29日 和 1月30日
            //如果是 新的是3月 29,30，对应旧的2月 -27和29日
            //如果 新的月份是2022年1月，老的必须是2021年12月 等价与 老数据 日期是 2021年12月，新数据必须是2022年01月

//        1.新增一个字段，存原始数据
//        2.截取新日期的年、月、日
//        3.判断新日期月份是2月和旧月相等，且新日期的年相等，如果新日期的日是28或27，则对比原始数据是否存在-1或-2，存在则执行任务
//        4.判断新月是1月并且旧月是12，新年等于旧年+1，新日等于旧日，则执行任务
//        5.即不是1月和2月，新年等于旧年，新日等于旧日，执行任务

         //1.新增一个 字段，存原始数据
//        2.对比日，直接对比原始数据，如果新日存在-1和-2，判断新月份是2月并且新数据的年和旧年相等，则执行27和28，不是则执行29和30
//        3.不存在-1和-2, 新数据的月是1月 ，旧数据年+1  旧年 和新年相同、并且 旧月 是12月，else 月是 新的3-12月 ，旧月 +1 相等新月，新年和旧年相等；
        for (String s : list) {
            boolean contains = s.contains(dNew);
            if (contains) {
                //步骤1.判断日期，是否再第一次执行日期范围中，不在直接跳出本次任务
                System.out.println("说明是有新的日范围" + list);

                if ("02".equals(mNew)){
                    //步骤3.如果是 新数据月是02月-27 ，28对应旧的数据日期，是1月29日 和 1月30日
                    if ("27".equals(dNew) ){
                        if ("29".equals(dOld)){
                            System.out.println("是1月29");
                        }else {
                            System.out.println("不是1月29");
                        }
                    }else if ("28".equals(dNew) ){
                        if ("30".equals(dOld)){
                            System.out.println("是1月30");
                        }else {
                            System.out.println("不是1月30");
                        }
                    }else {
                        //其他天正常执行查询
                    }
                }
                if ("03".equals(mNew)){
                    //如果是 新的是3月 29,30，对应旧的2月 -27和28日
                    if ("29".equals(dNew) ){
                        if ("27".equals(dOld)){
                            System.out.println("是2月27");
                        }else {
                            System.out.println("不是2月27");
                        }
                    }else if ("30".equals(dNew) ){
                        if ("28".equals(dOld)){
                            System.out.println("是2月28");
                        }else {
                            System.out.println("不是2月28");
                        }
                    }else {
                        //其他天正常执行查询
                    }
                }
                if ("01".equals(mNew)){
                    //如果 新的月份是2022年1月，老的必须是2021年12月 等价与 老数据 日期是 2021年12月，新数据必须是2022年01月
                    if ("29".equals(dNew) ){
                        if ("27".equals(dOld)){
                            System.out.println("是2月27");
                        }else {
                            System.out.println("不是2月27");
                        }
                    }else if ("30".equals(dNew) ){
                        if ("28".equals(dOld)){
                            System.out.println("是2月28");
                        }else {
                            System.out.println("不是2月28");
                        }
                    }else {
                        //其他天正常执行查询
                    }
                }
                String s1 = subMon(dateOld);//老的月加1个月和新的数据月，对比
                String sub = s1.substring(5, 7);//
                String substring2 = dataoldNew.substring(5, 7);
                if (sub.equals(mNew)) {
                    System.out.println("可以执行月一致");
                    // 步骤2.日期在范围内，判断月是否一致，一致执行。不一致，直接跳出
                    if (yOld.equals(yNew)) {
                        System.out.println("说明年可以执行");
                        System.out.println("end最后都可以执行");
                    } else {
                        System.out.println("年不可以执行");
                    }
                }else {
                    System.out.println("月不一致，不可执行");
                    //步骤2.日期在范围内，判断月是否一致，一致执行。不一致，直接跳出
                }

                System.out.println( "下次可以执行的月="+s1);

                System.out.println("要执行的新月=" + substring2);
                //01.判断月，是不是2月 12月
                if ("12".equals(dOld)){
                    //下次执行日期必须是另外一年
                    String s2 = subYYYY(yOld);
                    System.out.println("下次新跑的年0000="+s2);
                    if (s2.equals(yNew)){
                        //老的12月，要求新的日期，必须是 老的年加+1 和新的年对比，
                        System.out.println("说明12月和下一个新的年相比正确");
                    }else {
                        //新的年和 旧的年，不对
                        System.out.println("新的年和 旧的年，不对");

                    }
                }if ("02".equals(dOld)){
                    //如果是2月，需要注意 新跑的27,28，对应 29，30
                    if ("03".equals(dNew)){
                        System.out.println("是3月");
                        //情况1:老的

                        //情况2:
                        //情况3:
                        //情况4:

                        if (yOld.equals(yNew)) {
                            System.out.println("说明年可以执行");
                            System.out.println("end最后都可以执行");
                        } else {
                            System.out.println("年不可以执行");
                        }
                    }else {
                        System.out.println("3月份退出吧");
                    }
                } else if("01".equals(substring2)) {
                    //
                    if (yOld.equals(yNew)) {
                        System.out.println("说明年可以执行");
                        System.out.println("end最后都可以执行");
                    } else {
                        System.out.println("年不可以执行");
                    }
                }else {
                    System.out.println("月份不对");
                    System.out.println("直接退出去吧");

                }

            } else {
                System.out.println("库中没有日范围。直接跳出");
                //步骤1.判断日期，是否再第一次执行日期范围中，不在直接跳出本次任务
            }
        }

    }
    private static  String subMon(String data) {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM");
        String format="";
        try {
            Date parse = sdf.parse(data);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            instance.add(Calendar.MONTH,1);
            Date time = instance.getTime();
            format = sdf.format(time);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("日期转换异常");
        }
        return format;
    }
    private static  String subYYYY(String data) {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
        String format="";
        try {
            Date parse = sdf.parse(data);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            instance.add(Calendar.YEAR,1);
            Date time = instance.getTime();
            format = sdf.format(time);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("日期转换异常");
        }
        return format;
    }

}

package com.tingshuo.system.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月19日 13:27
 **/
public class TestT {
    public static void main(String[] args) {
//        1.新增一个字段，存原始数据
//        2.截取新日期的年、月、日
//        3.判断新日期月份是2月和旧月相等，且新日期的年相等，如果新日期的日是28或27，则对比原始数据是否存在-1或-2，存在则执行任务
//        4.判断新月是1月并且旧月是12，新年等于旧年+1，新日等于旧日，则执行任务
//        5.即不是1月和2月，新年等于旧年，新日等于旧日，执行任务
        String dateOld = "2021-06-02";
        String dataoldNew = "2021-07-02";
        String oldDat = "[01,02,05,06,07,09,10,26]";

        String yNew = dataoldNew.substring(0, 4);//新的年
        String mNew = dataoldNew.substring(5, 7);//新的月
        String dNew = dataoldNew.substring(8, 10);//新的日
        System.out.println("新的年=" + yNew);
        System.out.println("新的月=" + mNew);
        System.out.println("新的日=" + dNew);

        String yOld = dateOld.substring(0, 4); //老的年
        String mOld = dateOld.substring(5, 7);//旧的月
        String dOld = dateOld.substring(8, 10);//老的日
        System.out.println("老的年=" + yOld);
        System.out.println("旧的月=" + mOld);
        System.out.println("老的日=" + dOld);
//        数字旧月
        int a = Integer.parseInt(mOld);
        //        数字旧年
        int b = Integer.parseInt(yOld);
        //        数字新日
        int c = Integer.parseInt(dNew);
        //        数字新月
        int d = Integer.parseInt(mNew);

        if ("02".equals(mNew) && c <= 28) {
            if ((Integer.parseInt(mNew) == (a + 1)) && (yNew.equals(yOld))) {
                if ((dNew.equals("27"))) {
//                    System.out.println("2月27"+dNew);
                    boolean contains = oldDat.contains("-2");
                    if (contains) {
                        System.out.println("2月27正常执行任务-2");
                    } else {
                        System.out.println("2月27任务不正确！-2");
                    }
                } else if ((dNew.equals("28"))) {
                    boolean contains = oldDat.contains("-1");
                    if (contains) {
                        System.out.println("2月28正常执行任务-1");
                    } else {
                        System.out.println("2月28任务不正确！-1");
                    }
                } else if (!"27".equals(dNew) && !"28".equals(dNew)) {
                    boolean contains = oldDat.contains(dNew);
                    if (contains) {
                        System.out.println("2月2728正常执行任务bu-2-1");
                    } else {
                        System.out.println("2月2728不正常执行任务-2-1");
                    }
                } else {
                    System.out.println("2月任务不正确！-1-2");
                }
            }
        } else if ("01".equals(mNew) && (mOld.equals("12"))) {
//            boolean contains = oldDat.contains(dNew);
            if (dNew.equals("29")) {
                boolean contains = oldDat.contains("-2");
                if (contains && (Integer.parseInt(yNew) == b + 1)) {
                    System.out.println("01月29-2正常执行任务");
                } else {
                    System.out.println("0129-2不正常执行任务");
                }
            } else if (dNew.equals("30")) {
                boolean contains = oldDat.contains("-1");
                if (contains && (Integer.parseInt(yNew) == b + 1)) {
                    System.out.println("0130-1正常执行任务");
                } else {
                    System.out.println("0130-1不正常执行任务");
                }
            } else if (!dNew.equals("29") && !dNew.equals("30")) {
                boolean contains = oldDat.contains(dNew);
                if (contains) {
                    System.out.println("0129正常执行任务");
                } else {
                    System.out.println("0129bu正常执行任务");
                }
            } else {
                System.out.println("01bu正常执行任务");
            }

        } else if (!"01".equals(mNew) && !"02".equals(mNew) && (yNew.equals(yOld))) {
            System.out.println("(Integer.parseInt(mNew)==(a+1))" + (Integer.parseInt(mNew) == (a + 1)));
            System.out.println("(yNew.equals(yOld))" + (yNew.equals(yOld)));
            if ((Integer.parseInt(mNew) == (a + 1))) {
                if (dNew.equals("29")) {
                    boolean contains = oldDat.contains("-2");
                    if (contains) {
                        System.out.println("不是1和2月29正常执行任务");
                    } else {
                        System.out.println("不是1和2月29不正常执行任务");
                    }
                } else if (dNew.equals("30")) {
                    boolean contains = oldDat.contains("-1");
                    if (contains) {
                        System.out.println("不是1和2月30正常执行任务");
                    } else {
                        System.out.println("不是1和2月30bu正常执行任务");
                    }
                } else if (!dNew.equals("29") && !dNew.equals("30")) {
                    boolean contains = oldDat.contains(dNew);
                    if (contains) {
                        System.out.println("不是1和2月也不是2930正常执行任务");
                    } else {
                        System.out.println("不是1和2月也不是2930不正常执行任务");
                    }
                } else {
                    System.out.println("不是1和2月不正常执行任务");
                }
            } else {
                System.out.println("01111bu正常执行任务");
            }

        } else {
            System.out.println("任务不正确！===最特殊");
        }
    }

    /**
     * 年+1
     * @param data
     * @return
     */
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

    /**
     * 月+1
     * @param data
     * @return
     */
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
}

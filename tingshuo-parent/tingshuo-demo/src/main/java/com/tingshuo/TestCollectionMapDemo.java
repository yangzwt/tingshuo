package com.tingshuo;

import java.util.*;

/**
 * packageName com.tingshuo
 *
 * @author yangz
 * @version JDK 8
 * @className TestCollectionMapDemo (此处以class为例)
 * @date 2024/10/1-22:23
 * @description TODO
 */
public class TestCollectionMapDemo {
    /**
     *
     * @return
     */
    public String test(){
        return "test";
    }

    public static void main(String[] args) {
        //list 去重
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("List:"+list);
        //不重复
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("3");
        System.out.println("Set:" + set);
        Queue queue = new LinkedList();
        queue.add("1");
        queue.add("2");
        queue.add("2");
        queue.add("3");
        System.out.println(queue.poll());
        Object poll = queue.poll();
        System.out.println("Queue:" + queue);
        queue.add("3");

        System.out.println("Poll:" + poll);
        //map集合
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        System.out.println("Map:"+map);


    }
}

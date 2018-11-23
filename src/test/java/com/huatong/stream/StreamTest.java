package com.huatong.stream;

import com.huatong.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create By xzz on 2018/10/26
 */
public class StreamTest {


    public static void main(String[] args) {
//        select();
//        //集合获取流
//        List<User> list = new ArrayList<>();
//        User xie = new User("xie", 10);
//        User zong = new User("zong", 18);
//        User ze = new User("ze", 28);
//        list.add(xie);
//        list.add(zong);
//        list.add(ze);
//        String str = "xie=13;zong=13";
//
//        chararray();
//        map(str);


//        list = list.stream().filter(element -> element.getAge() > 10).limit(1).collect(Collectors.toList());
//        long i = list.stream().filter(element -> element.getAge() > 10).limit(1).count();
//        System.out.println(i);
//        print(list);
//
//        Map<String, String> map = new HashMap<>();
//        Stream<Map.Entry<String, String>> maps = map.entrySet().stream();
//
//        //数组获取流
//        String[] arr = new String[4];
//        Stream<String> arrs = Arrays.stream(arr);
        print();

    }

    private static void chararray() {
//        String[] arr = {"12","13","14","15"};
//
//        Arrays.stream(arr);





    }

    private static void map(String str) {
        Map<String, String> map = new HashMap<>();
        //1
        Stream<String> stream1 = Arrays.stream(str.split(";")).filter(str1 -> str1.contains("="));
        //2
        Arrays.stream(str.split(";"))
                .filter(kv -> kv.contains("="))
                .forEach(array -> {
                    String[] arr = array.split("=");
                    map.put(arr[0], arr[1]);
                });
        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        });
        //3
        Stream<Map.Entry<String, String>> stream2 = map.entrySet().stream();
    }

    private static void select() {
        String aa = "key";
        HashMap<String, String> map = new HashMap<>();
        String str = "name=xie;age=18";
        Arrays.stream(str.split(";")).filter(entry -> entry.contains("=")).forEach(string -> {
            String[] arr = string.split("=");
            System.out.println("===" + arr[0] + "=" + arr[1]);
        });


        map.entrySet().stream().filter(entry -> entry.getKey().equals("name")).forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
    }

    private static void print() {
       List<Integer> list1 = new ArrayList<>();
       list1.add(1);
       list1.add(2);
       list1.add(3);
       list1.add(4);
       list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        list1.removeAll(list2);

        for (Integer i:list1){
            System.out.println(i);
        }


    }


}

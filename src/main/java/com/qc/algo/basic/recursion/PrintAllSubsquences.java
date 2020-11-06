package com.qc.algo.basic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author qinc 2020/11/04 11:04
 */
public class PrintAllSubsquences {

    public static List<String> sub(String str) {
        List<String> list = new ArrayList<>();
        process(str.toCharArray(),0,list,"");
        return list;
    }

    public static void process(char[] arr, int index, List<String> list, String path) {
        if (index == arr.length) {
            if (path.length()>0){
                list.add(path);
            }
        } else {
            process(arr, index + 1, list, path);
            process(arr, index + 1, list, path + String.valueOf(arr[index]));
        }
    }

    public static void main(String[] args) {
        List<String> list = sub("abcd");
        for(String s:list){
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}

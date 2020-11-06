package com.qc.algo.basic.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description
 *
 * @author qinc 2020/11/04 10:36
 */
public class PrintAllPermutations {

    public static List<String> sub(String str) {
        if (str == null || str == "") {
            return null;
        }
        List<String> list = new ArrayList<>();
        Set<Integer> use = new HashSet<>();
        process(str.toCharArray(), list, use, "");
        return list;
    }

    public static void process(char[] arr, List<String> list, Set<Integer> use, String sb) {
        if (use.size() == arr.length) {
            if (sb.length() > 0) {
                list.add(sb);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!use.contains(i)) {
                    use.add(i);
                    process(arr, list, use, sb + String.valueOf(arr[i]));
                    use.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = sub("abc");

        for(String s:list){
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}

package com.qc.algo.basic.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * description
 *
 * @author qinc 2020/10/23 17:06
 */
public class StreetLight {

    public static int right(String street) {
        if (street == null || street.length() == 0) {
            return 0;
        }
        Set<Integer> lights = new HashSet<>();
        return process(street.toCharArray(), 0, lights);
    }

    public static int process(char[] arr, int index, Set<Integer> lights) {
        if (index == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '.') {
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else {
            int no = process(arr, index + 1, lights);
            int yes = Integer.MAX_VALUE;
            if (arr[index] == '.') {
                lights.add(index);
                yes = process(arr, index + 1, lights);
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }

    public static int lights(String street) {
        if (street == null || street.length() == 0) {
            return 0;
        }
        char[] arr = street.toCharArray();
        int lights = 0;
        int index = 0;
        while (index < arr.length) {
            if (arr[index] == 'X') {
                index++;
            } else {
                lights++;
                if (index + 1 == arr.length) {
                    index++;
                } else {
                    if (arr[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }
        return lights;
    }

    public static void main(String[] args) {
        int len = 20;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            String test = randomString(len);
            int ans1 = right(test);
            int ans2 = lights(test);
            if (ans1 != ans2) {
                System.out.println(ans1 + "-->" + ans2);
                System.out.println("oops!");
            }
        }
        System.out.println("finish!");
    }

    public static String randomString(int len) {
        char[] res = new char[(int) (Math.random() * len) + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.random() < 0.5 ? 'X' : '.';
        }
        return String.valueOf(res);
    }
}

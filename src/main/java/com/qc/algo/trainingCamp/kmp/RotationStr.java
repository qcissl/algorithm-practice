package com.qc.algo.trainingCamp.kmp;

/**
 * description
 *
 * @author qinc 2020/11/19 10:55
 */
public class RotationStr {

    public static boolean isRotation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        int index = KMP.indexOf(str1 + str1, str2);
        return index > -1;
    }

    public static void main(String[] args) {
        String str1 = "yunzuocheng";
        String str2 = "zuochengyun";
        System.out.println(isRotation(str1, str2));

    }
}

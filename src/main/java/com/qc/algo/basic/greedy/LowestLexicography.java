package com.qc.algo.basic.greedy;

import java.util.*;

/**
 * description
 *
 * @author qinc 2020/10/23 10:44
 */
public class LowestLexicography {

    public static String right(String[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        Set<Integer> use = new HashSet<>();
        List<String> all = new ArrayList<>();
        process(arr, use, all, "");
        all.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return all.get(0);
    }

    public static void process(String[] arr, Set<Integer> use, List<String> all, String path) {
        if (use.size() == arr.length) {
            all.add(path);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!use.contains(i)) {
                    use.add(i);
                    process(arr, use, all, path + arr[i]);
                    use.remove(i);
                }
            }
        }
    }

    public static String lowest(String arr[]) {
        if (arr == null) {
            return null;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int arrLen = 6;
        int strLen = 5;
        int testTimes = 100000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String[] arr1 = generateRandomStringArray(arrLen, strLen);
            String[] arr2 = copyStringArray(arr1);
            if (!right(arr1).equals(lowest(arr2))) {
                for (String str : arr1) {
                    System.out.print(str + ",");
                }
                System.out.println();
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    // for test
    public static String[] copyStringArray(String[] arr) {
        String[] ans = new String[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = String.valueOf(arr[i]);
        }
        return ans;
    }

    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 5);
            ans[i] = (Math.random() <= 0.5) ? (char) (65 + value) : (char) (97 + value);
        }

        return String.valueOf(ans);
    }
}

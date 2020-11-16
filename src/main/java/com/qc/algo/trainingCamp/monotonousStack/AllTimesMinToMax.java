package com.qc.algo.trainingCamp.monotonousStack;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.*;

/**
 * description
 *
 * @author qinc 2020/11/14 16:57
 */
public class AllTimesMinToMax {

    public static int right(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return process(arr, 0, new ArrayList<>());
    }

    public static int process(int[] arr, int index, List<Integer> list) {

        if (index == arr.length) {
            if (list.size() == 0) {
                return 0;
            }
            list.sort((o1, o2) -> o1 - o2);
            int s = list.stream().mapToInt(o -> o).sum();
            return s * list.get(0);
        }
        int max = 0;

        if (list.isEmpty()) {
            max = Math.max(max, process(arr, index + 1, list));
        } else {
            list.sort((o1, o2) -> o1 - o2);
            int s = list.stream().mapToInt(o -> o).sum();
            max = Math.max(max, s * list.get(0));
        }
        max = Math.max(max, process(arr, index + 1, getList(list, arr[index])));
        return max;
    }

    private static List<Integer> getList(List<Integer> list, int i) {
        List<Integer> list1 = new ArrayList<>(list);
        list1.add(i);
        return list1;
    }

    public static int getMax(int[] arr) {

        int max = 0;
        int min = 0;
        int L = 0;
        int R = 0;
        int[][] result = MonotonousStack.getNearLess(arr);
        if (result != null) {
            int[] arr1 = getSum(arr);
            for (int i = 0; i < result.length; i++) {
                min = arr[i];
                L = result[i][0];
                R = result[i][1] == -1 ? arr.length - 1 : result[i][1] - 1;
                max = Math.max(max, (arr1[R] - (L > -1 ? arr1[L] : 0)) * min);
            }
        }
        return max;
    }

    private static int[] getSum(int[] arr) {
        int[] arr1 = new int[arr.length];
        arr1[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr1[i] = arr1[i - 1] + arr[i];
        }
        return arr1;
    }

    public static void main(String[] args) {
        int testTimes = 2000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = CheckCompareSortUtil.createArray(10,100);
            if (right(arr) != getMax(arr)) {
                System.out.println("FUCK!");
                break;
            }
        }
        System.out.println("test finish");
    }
}

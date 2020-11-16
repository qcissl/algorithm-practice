package com.qc.algo.basic.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * description
 *
 * @author qinc 2020/10/09 10:35
 */
public class CheckCompareSortUtil {

    public static int[] createArray(int size, int maxValue) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }
    public static int[] createArrayNoRepeat(int size, int maxValue) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        Set<Integer> set = new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        arr = new int[set.size()];
        Integer[] objects = set.toArray(new Integer[]{});
        for(int i = 0; i < objects.length; i++) {
            arr[i] = objects[i];
        }
        return arr;
    }

    public static int[] copyArray(int[] origin) {
        int[] arr = new int[origin.length];
        for (int i = 0; i < origin.length; i++) {
            arr[i] = origin[i];
        }
        return arr;
    }

    public static boolean checkArray(ArraySort arraySort, int iteratorSize, int arrSize, int maxValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iteratorSize; i++) {
            int[] origin = createArray(arrSize, maxValue);
            int[] copy = copyArray(origin);
            sysSortArray(origin);
            arraySort.sortArray(copy);

            for (int j = 0; j < origin.length; j++) {
                if (origin[j] != copy[j]) {
                    System.out.println("error");
                    System.out.println(Arrays.toString(origin));
                    System.out.println(Arrays.toString(copy));
                    return false;
                }
            }
        }
        System.out.println("waster time : " + (System.currentTimeMillis() - startTime) + " ms");
        return true;
    }

    public static void sysSortArray(int[] arr) {
        Arrays.sort(arr);
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean checkArray(ArraySort arraySort) {
        return checkArray(arraySort, 100000, 100, 500000);
    }

    public static boolean checkArray(int[] sample1, int[] sample2) {
        if (sample1 == sample2) {
            return true;
        }
        if (sample1.length != sample2.length) {
            return false;
        }
        for (int i = 0; i < sample1.length; i++) {
            if (sample1[i] != sample2[i]) {
                System.out.println("error");
                System.out.println(Arrays.toString(sample1));
                System.out.println(Arrays.toString(sample2));
                return false;
            }
        }
        return true;
    }
}

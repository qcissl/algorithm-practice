package com.qc.algo.basic.sort;

import java.util.Arrays;

/**
 * description
 *
 * @author qinc 2020/10/09 10:35
 */
public class CheckUtil {

    public static int[] createArray(int size, int maxValue) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
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
}

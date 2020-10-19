package com.qc.algo.basic.bucket;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * description
 *
 * @author qinc 2020/10/19 9:45
 */
public class RadixSort {

    public static void baseRadix(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        ArrayList<Integer>[] container = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            container[i] = new ArrayList<>();
        }
        int d = getLength(max);
        for (int i = 1; i <= d; i++) {
            for (int j = 0; j < arr.length; j++) {
                int t = getValue(arr[j], i);
                container[t].add(arr[j]);
            }
            int index = 0;
            for (int j = 0; j < container.length; j++) {
                Iterator<Integer> it = container[j].iterator();
                while (it.hasNext()) {
                    arr[index++] = it.next();
                    it.remove();
                }
            }
        }
    }

    public static void classicRadix(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int d = getLength(max);
        int[] help = new int[arr.length];

        for (int i = 1; i <= d; i++) {
            int[] count = new int[10];
            for (int j = 0; j < arr.length; j++) {
                int t = getValue(arr[j], i);
                count[t]++;
            }

            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }

            for (int j = arr.length - 1; j >= 0; j--) {
                int t = getValue(arr[j], i);
                help[count[t] - 1] = arr[j];
                count[t]--;
            }

            for (int j = 0; j < help.length; j++) {
                arr[j] = help[j];
            }

        }
    }

    private static int getValue(int t, int d) {
        return ((t / ((int) Math.pow(10, d - 1))) % 10);
    }

    private static int getLength(int t) {
        int d = 0;
        while (t != 0) {
            d++;
            t = t / 10;
        }
        return d;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = CheckCompareSortUtil.createArray(10, 100);
            int[] copy = CheckCompareSortUtil.copyArray(arr);
            classicRadix(arr);
            Arrays.sort(copy);
            CheckCompareSortUtil.checkArray(arr, copy);
        }
    }


}

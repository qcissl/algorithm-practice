package com.qc.algo.basic.bucket;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.Arrays;

/**
 * description
 *
 * @author qinc 2020/10/19 9:04
 */
public class CountSort {

    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] = count[arr[i]] + 1;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        /*int[] arr = CheckCompareSortUtil.createArray(10,10);
        System.out.println(Arrays.toString(arr));
        countSort(arr);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = CheckCompareSortUtil.createArray(100, 100);
        int[] copy = CheckCompareSortUtil.copyArray(arr);
        countSort(arr);
        Arrays.sort(copy);
        CheckCompareSortUtil.checkArray(arr, copy);
    }
}

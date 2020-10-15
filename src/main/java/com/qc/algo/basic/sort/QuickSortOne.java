package com.qc.algo.basic.sort;

import com.qc.algo.basic.partition.Partition;

/**
 * description
 *
 * @author qinc 2020/10/15 15:50
 */
public class QuickSortOne implements ArraySort {

    @Override
    public void sortArray(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    public void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = Partition.partition(arr, L, R);
        process(arr, L, mid - 1);
        process(arr, mid + 1, R);
    }

    public static void main(String[] args) {
        CheckCompareSortUtil.checkArray(new QuickSortOne());
    }
}

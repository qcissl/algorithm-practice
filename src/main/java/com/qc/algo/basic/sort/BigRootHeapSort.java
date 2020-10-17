package com.qc.algo.basic.sort;

import com.qc.algo.basic.heap.BigRootHeap;

/**
 * description
 *
 * @author qinc 2020/10/15 22:30
 */
public class BigRootHeapSort implements ArraySort {
    @Override
    public void sortArray(int[] arr) {
        BigRootHeap heap = new BigRootHeap(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = heap.pop();
        }
    }

    public static void main(String[] args) {
        CheckCompareSortUtil.checkArray(new BigRootHeapSort());
    }
}

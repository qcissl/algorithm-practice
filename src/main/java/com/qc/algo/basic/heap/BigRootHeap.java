package com.qc.algo.basic.heap;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.Arrays;

/**
 * description
 *
 * @author qinc 2020/10/15 22:01
 */
public class BigRootHeap {

    private int[] heap;
    private int limit;
    private int heapSize;

    public BigRootHeap(int limit) {
        this.limit = limit;
        heap = new int[limit];
        heapSize = 0;
    }

    public BigRootHeap(int[] heap) {
        this.heap = heap;
        this.limit = heap.length;
        this.heapSize = limit;
        for (int i = heap.length - 1; i >= 0; i--) {
            heapify(heap, i, heap.length);
        }
    }

    public void push(int t) {
        if (isFull()) {
            return;
        }
        heap[heapSize] = t;
        heapInsert(heap, heapSize++);
    }

    public int pop() {
        int t = heap[0];
        CheckCompareSortUtil.swap(0, --heapSize, heap);
        heapify(heap, 0, heapSize);
        return t;
    }

    private void heapify(int[] arr, int index, int size) {

        int left = index * 2 + 1;
        while (left < size) {
            int tIndex = left;
            int right = left + 1;

            if (right < size) {
                tIndex = arr[right] > arr[left] ? right : left;
            }
            if (arr[tIndex] > arr[index]) {
                CheckCompareSortUtil.swap(tIndex, index, arr);
            } else {
                break;
            }
            index = tIndex;
            left = tIndex * 2 + 1;
        }
    }

    private void heapInsert(int[] arr, int index) {

        while (arr[index] > arr[((index - 1) / 2)]) {
            CheckCompareSortUtil.swap(index, ((index - 1) / 2), arr);
            index = (index - 1) / 2;
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }

    public static void main(String[] args) {
        int[] origin = CheckCompareSortUtil.createArray(5, 10);
        BigRootHeap bigRootHeap = new BigRootHeap(origin.length);
        for (int i = 0; i < origin.length; i++) {
            bigRootHeap.push(origin[i]);
        }
        bigRootHeap.printHeap();
        for (int i = 0; i < origin.length; i++) {
            bigRootHeap.pop();
            bigRootHeap.printHeap();
        }
    }
}

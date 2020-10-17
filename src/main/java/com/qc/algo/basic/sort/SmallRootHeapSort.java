package com.qc.algo.basic.sort;

import com.qc.algo.basic.heap.SmallRootHeap;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * description
 *
 * @author qinc 2020/10/17 10:35
 */
public class SmallRootHeapSort implements ArraySort {
    @Override
    public void sortArray(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int t:arr){
            arrayList.add(t);
        }
        SmallRootHeap<Integer> smallRootHeap = new SmallRootHeap(arrayList,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            smallRootHeap.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = smallRootHeap.pop();
        }
    }

    public static void main(String[] args) {
        CheckCompareSortUtil.checkArray(new BigRootHeapSort());
    }
}

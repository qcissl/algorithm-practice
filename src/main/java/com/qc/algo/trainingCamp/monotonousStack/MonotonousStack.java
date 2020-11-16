package com.qc.algo.trainingCamp.monotonousStack;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description
 *
 * @author qinc 2020/11/14 13:45
 */
public class MonotonousStack {

    public static int[][] getNearLessNoRepeat(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int[][] result = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int pos = 0;
        while (index < arr.length) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[index]) {
                pos = stack.pop();
                if (stack.isEmpty()) {
                    result[pos][0] = -1;
                } else {
                    result[pos][0] = stack.peek();
                }
                result[pos][1] = index;
            }
            stack.push(index);
            index++;
        }

        while (!stack.isEmpty()) {
            pos = stack.pop();
            if (stack.isEmpty()) {
                result[pos][0] = -1;
            } else {
                result[pos][0] = stack.peek();
            }
            result[pos][1] = -1;
        }

        return result;
    }

    public static int[][] getNearLess(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int[][] result = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        int index = 0;
        List<Integer> pos = null;

        while (index < arr.length) {
            while (!stack.isEmpty() && arr[stack.peek().get(stack.peek().size() - 1)] > arr[index]) {
                pos = stack.pop();
                for (int i = pos.size() - 1; i >= 0; i--) {
                    if (stack.isEmpty()) {
                        result[pos.get(i)][0] = -1;
                    } else {
                        List<Integer> pos1 = stack.peek();
                        result[pos.get(i)][0] = pos1.get(pos1.size() - 1);
                    }
                    result[pos.get(i)][1] = index;
                }
            }
            if (stack.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(index);
                stack.push(list);
            } else {
                pos = stack.peek();
                if (arr[index] == arr[pos.get(0)]) {
                    pos.add(index);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(index);
                    stack.push(list);
                }
            }
            index++;
        }

        while (!stack.isEmpty()) {
            pos = stack.pop();
            for (int i = pos.size() - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    result[pos.get(i)][0] = -1;
                } else {
                    List<Integer> pos1 = stack.peek();
                    result[pos.get(i)][0] = pos1.get(pos1.size() - 1);
                }
                result[pos.get(i)][1] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        getNearLess(new int[]{15,7,20,7,4});
        int size = 5;
        int max = 20;
        int testTimes = 2000000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = CheckCompareSortUtil.createArrayNoRepeat(size, max);
            int[] arr2 = CheckCompareSortUtil.createArray(size, max);
            if (!isEqual(getNearLessNoRepeat(arr1), rightWay(arr1))) {
                System.out.println("Oops!");
                break;
            }
            int[][] result1 = getNearLess(arr2);
            int[][] result2 = rightWay(arr2);
            if (!isEqual(result1, result2)) {
                System.out.println("Oops!");
                break;
            }
        }
    }

    public static int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[][] res1, int[][] res2) {
        if (res1.length != res2.length) {
            return false;
        }
        for (int i = 0; i < res1.length; i++) {
            if (res1[i][0] != res2[i][0] || res1[i][1] != res2[i][1]) {
                return false;
            }
        }

        return true;
    }
}

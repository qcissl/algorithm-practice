package com.qc.algo.trainingCamp.reservoir;

/**
 * description
 *
 * @author qinc 2020/11/18 11:08
 */
public class ReservoirSampling {

    public static class RandomBox {
        final int[] arr;
        int size = 0;
        final int limit;

        RandomBox(int choose) {
            this.arr = new int[choose];
            this.limit = choose;
        }

        public void push(int num) {
            size++;
            if (size > limit) {
                int v = (int) (Math.random() * size) + 1;
                if (v <= limit) {
                    int index = (int) (Math.random() * limit) + 1;
                    arr[index - 1] = num;
                }
            } else {
                arr[size - 1] = num;
            }
        }

        public int[] getArr() {
            return arr;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello");
        int all = 100;
        int choose = 10;
        int testTimes = 50000;
        int[] counts = new int[all + 1];
        for (int i = 0; i < testTimes; i++) {
            RandomBox box = new RandomBox(choose);
            for (int num = 1; num <= all; num++) {
                box.push(num);
            }
            int[] ans = box.getArr();
            for (int j = 0; j < ans.length; j++) {
                counts[ans[j]]++;
            }
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + " times : " + counts[i]);
        }

    }
}

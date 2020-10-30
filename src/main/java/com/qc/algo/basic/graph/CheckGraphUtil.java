package com.qc.algo.basic.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * description
 *
 * @author qinc 2020/10/29 9:39
 */
public class CheckGraphUtil {

    private static class FromTo {
        int from;
        int to;
        String edge;

        public FromTo(int from, int to) {
            this.from = from;
            this.to = to;
            if (from > to) {
                this.edge = to + "-" + from;
            } else {
                this.edge = from + "-" + to;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FromTo fromTo = (FromTo) o;

            return edge.equals(fromTo.edge);
        }

        @Override
        public int hashCode() {
            return edge.hashCode();
        }
    }

    public static int[][] matrixDirectCreate(int maxSize, int maxValue, int maxWeight) {
        int size = (int) (Math.random() * (maxSize - 1)) + 2;
        Set<Integer> pointSet = new HashSet<>();
        Set<FromTo> fromToSet = new HashSet<>();

        while (pointSet.size() != size) {
            pointSet.add((int) (Math.random() * (maxValue + 1)));
        }
        Integer[] select = pointSet.toArray(new Integer[]{});

        int j = 0;
        int index = 0;
        Stack<Integer> last = new Stack<>();
        for (int i = 0; i < select.length; i++) {
            index = (int) (Math.random() * size);
            while (index < size) {
                if (index == size - 1 && i > 0) {
                    j = last.pop();
                    while (i == j) {
                        j = last.pop();
                    }
                } else {
                    j = (int) (Math.random() * size);
                    while (i == j) {
                        j = (int) (Math.random() * size);
                    }
                }
                fromToSet.add(new FromTo(select[i], select[j]));
                index++;
                last.push(j);
            }
        }

        int[][] matrix = new int[fromToSet.size()][3];
        int i = 0;
        for (FromTo fromTo : fromToSet) {
            int weight = (int) (Math.random() * maxWeight) + 1;
            matrix[i][0] = weight;
            matrix[i][1] = fromTo.from;
            matrix[i][2] = fromTo.to;
            i++;
        }

        return matrix;
    }


    public static int[][] matrixNoDirectCreate(int maxSize, int maxValue, int maxWeight) {
        int size = (int) (Math.random() * (maxSize - 1)) + 2;
        Set<Integer> pointSet = new HashSet<>();
        Set<FromTo> fromToSet = new HashSet<>();

        while (pointSet.size() != size) {
            pointSet.add((int) (Math.random() * (maxValue + 1)));
        }
        Integer[] select = pointSet.toArray(new Integer[]{});

        for (int i = 0; i < select.length; i++) {
            for (int j = 0; j < select.length; j++) {
                if (i == j) {
                    continue;
                }
                fromToSet.add(new FromTo(select[i], select[j]));
            }
        }

        int[][] matrix = new int[fromToSet.size()*2][3];
        int i = 0;
        for (FromTo fromTo : fromToSet) {
            int weight = (int) (Math.random() * maxWeight) + 1;
            matrix[i][0] = weight;
            matrix[i][1] = fromTo.from;
            matrix[i++][2] = fromTo.to;
            matrix[i][0] = weight;
            matrix[i][1] = fromTo.to;
            matrix[i++][2] = fromTo.from;
        }

        return matrix;
    }

}

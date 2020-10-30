package com.qc.algo.basic.graph;

import java.util.*;

/**
 * description
 *
 * @author qinc 2020/10/29 9:33
 */
public class GraphBFS {

    public static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Node> set = new HashSet<>();
        set.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.value);

            for (Node next : node.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = CheckGraphUtil.matrixDirectCreate(10,100,100);
        System.out.println("matrix:"+matrix.length);
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][1]+"-"+matrix[i][2]);
        }
        Graph graph = GraphGenerator.generator(matrix);
        System.out.println("size:"+graph.nodes.size());
        for(Node node:graph.nodes.values()){
            bfs(node);
            break;
        }
    }
}

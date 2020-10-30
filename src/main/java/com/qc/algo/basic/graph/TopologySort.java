package com.qc.algo.basic.graph;

import java.util.*;

/**
 * description
 *
 * @author qinc 2020/10/29 15:46
 */
public class TopologySort {

    public static List<Node> sort(Graph graph) {
        List<Node> result = new ArrayList<>();
        Map<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            map.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }

        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            result.add(node);
            for (Node next : node.nexts) {
                map.put(next, map.get(next) - 1);
                if (map.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = CheckGraphUtil.matrixNoDirectCreate(10, 100, 100);
        Graph graph = GraphGenerator.generator(matrix);
        System.out.println("size:" + graph.nodes.size());
        List<Node> list = sort(graph);
        System.out.println(list.size());
    }
}

package com.qc.algo.basic.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * description
 *
 * @author qinc 2020/10/29 16:46
 */
public class Prim {

    public static int prim(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        Set<Node> nodeSet = new HashSet<>();

        int result = 0;
        for (Node node : graph.nodes.values()) {
            nodeSet.add(node);
            for (Edge edge : node.edges) {
                queue.add(edge);
            }

            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                if (!nodeSet.contains(edge.to)) {
                    nodeSet.add(edge.to);
                    result += edge.weight;
                    for (Edge edge1 : edge.to.edges) {
                        queue.add(edge1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = CheckGraphUtil.matrixNoDirectCreate(10, 100, 100);
        Graph graph = GraphGenerator.generator(matrix);
        System.out.println(prim(graph));
        System.out.println(Kruskal.kruskal(graph));
    }

}

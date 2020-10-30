package com.qc.algo.basic.graph;

import com.qc.algo.basic.unionSet.UnionFindSet;

import java.util.*;

/**
 * description
 *
 * @author qinc 2020/10/29 16:22
 */
public class Kruskal {

    public static int kruskal(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        List<Node> points = new ArrayList<>();
        for (Edge edge : graph.edges) {
            queue.add(edge);
            points.add(edge.from);
            points.add(edge.to);
        }
        UnionFindSet findSet = new UnionFindSet(points);

        int result = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (!findSet.isSameSet(edge.from, edge.to)) {
                findSet.union(edge.from, edge.to);
                result += edge.weight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = CheckGraphUtil.matrixNoDirectCreate(10, 100, 100);
        Graph graph = GraphGenerator.generator(matrix);
        System.out.println(kruskal(graph));
    }

}

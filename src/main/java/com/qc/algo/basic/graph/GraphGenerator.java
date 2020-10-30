package com.qc.algo.basic.graph;

/**
 * description
 *
 * @author qinc 2020/10/29 9:04
 */
public class GraphGenerator {

    public static Graph generator(int[][] matrix) {
        Graph graph = new Graph();
        if (matrix == null) {
            return graph;
        }
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);

            fromNode.out = fromNode.out + 1;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);

            toNode.in = toNode.in + 1;

            graph.edges.add(edge);
        }
        return graph;
    }

}

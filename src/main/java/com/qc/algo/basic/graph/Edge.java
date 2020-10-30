package com.qc.algo.basic.graph;

/**
 * description
 *
 * @author qinc 2020/10/29 8:59
 */
public class Edge {

    int weight;
    Node from;
    Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}

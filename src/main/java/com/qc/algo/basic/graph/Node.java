package com.qc.algo.basic.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author qinc 2020/10/29 8:58
 */
public class Node {

    int value;
    int in;
    int out;
    List<Node> nexts;
    List<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

}

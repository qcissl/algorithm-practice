package com.qc.algo.basic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author qinc 2020/10/29 9:01
 */
public class Graph {

    Map<Integer, Node> nodes;
    List<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new ArrayList<>();
    }
}

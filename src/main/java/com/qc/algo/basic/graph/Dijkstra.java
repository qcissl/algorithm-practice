package com.qc.algo.basic.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * description
 *
 * @author qinc 2020/10/30 9:19
 */
public class Dijkstra {

    public static Map<Node, Integer> dijkstra(Node from) {

        Map<Node, Integer> distanceMap = new HashMap<>();
        Set<Node> nodeSet = new HashSet<>();

        distanceMap.put(from, 0);
        Node node = findMinNode(distanceMap, nodeSet);
        while (node != null) {
            Integer distance = distanceMap.get(node);
            for (Edge edge : node.edges) {
                if (!distanceMap.containsKey(edge.to)) {
                    distanceMap.put(edge.to, edge.weight + distance);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(edge.to), edge.weight + distance));
                }
            }
            nodeSet.add(node);
            node = findMinNode(distanceMap, nodeSet);
        }

        return distanceMap;
    }

    public static Node findMinNode(Map<Node, Integer> distanceMap, Set<Node> nodeSet) {

        int minValue = Integer.MAX_VALUE;
        Node node = null;
        for (Node key : distanceMap.keySet()) {
            if (!nodeSet.contains(key)) {
                int t = Math.min(minValue, distanceMap.get(key));
                if (minValue != t) {
                    node = key;
                    minValue = t;
                }
            }
        }
        return node;
    }

    public static class NodeRecord {
        Node node;
        int weight;

        public NodeRecord(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static Map<Node, Integer> bestDijkstra(Node from) {
        SmallRootHeapForDijkstra smallRootHeap = new SmallRootHeapForDijkstra(100);
        smallRootHeap.insertOrUpdateOrIgnore(new NodeRecord(from, 0));
        Map<Node, Integer> result = new HashMap<>();

        while (!smallRootHeap.isEmpty()) {
            NodeRecord record = smallRootHeap.pop();
            Integer distance = record.weight;
            for (Edge edge : record.node.edges) {
                smallRootHeap.insertOrUpdateOrIgnore(new NodeRecord(edge.to, edge.weight + distance));
            }
            result.put(record.node, record.weight);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = CheckGraphUtil.matrixNoDirectCreate(10, 100, 100);
        Graph graph = GraphGenerator.generator(matrix);
        for (Node node : graph.nodes.values()) {
            int sum = 0;
            for (Integer i : dijkstra(node).values()) {
                sum += i;
            }
            System.out.println(sum);
            sum = 0;
            for (Integer i : bestDijkstra(node).values()) {
                sum += i;
            }
            System.out.println(sum);
            break;
        }
    }
}

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
        Map<Node, NodeRecord> recordMap = new HashMap<>();
        recordMap.put(from, new NodeRecord(from, 0));
        smallRootHeap.push(recordMap.get(from));
        Map<Node, Integer> result = new HashMap<>();

        while (!smallRootHeap.isEmpty()) {
            NodeRecord record = smallRootHeap.pop();
            Integer distance = record.weight;
            for (Edge edge : record.node.edges) {
                if (recordMap.containsKey(edge.to)) {
                    NodeRecord nodeRecord = recordMap.get(edge.to);
                    nodeRecord.weight = Math.min(nodeRecord.weight, edge.weight + distance);
                    smallRootHeap.insertOrUpdateOrIgnore(nodeRecord);
                } else {
                    recordMap.put(edge.to, new NodeRecord(edge.to, edge.weight + distance));
                    smallRootHeap.insertOrUpdateOrIgnore(recordMap.get(edge.to));
                }
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

    public static HashMap<Node, Integer> dijkstra1(Node from) {
        // 从head出发到所有点的最小距离
        // key : 从head出发到达key
        // value : 从head出发到达key的最小距离
        // 如果在表中，没有T的记录，含义是从head出发到T这个点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);
        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰
        HashSet<Node> selectedNodes = new HashSet<>();
        // from 0
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to,
                            Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(
            HashMap<Node, Integer> distanceMap,
            HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}

package com.qc.algo.basic.unionSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description
 *
 * @author qinc 2020/10/27 17:27
 */
public class UnionFindSet<V> {

    Map<V, Node<V>> nodeMap = new HashMap<>();
    Map<Node<V>, Node<V>> parentMap = new HashMap<>();
    Map<Node<V>, Integer> nodeSizeMap = new HashMap<>();

    public UnionFindSet(List<V> list) {

        if (list != null) {
            for (V v : list) {
                Node node = new Node(v);
                this.nodeMap.put(v, node);
                this.parentMap.put(node, node);
                this.nodeSizeMap.put(node, 1);
            }
        }
    }

    public static class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public boolean isSameSet(V x, V y) {
        Node node1 = findFather(x);
        Node node2 = findFather(y);
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1 == node2;
    }

    public void union(V x, V y) {
        Node node1 = findFather(x);
        Node node2 = findFather(y);
        if (node1 == null || node2 == null) {
            return;
        }
        if (node1 == node2) {
            return;
        }

        int size1 = nodeSizeMap.get(node1);
        int size2 = nodeSizeMap.get(node2);
        if (size1 >= size2) {
            parentMap.put(node2, node1);
            nodeSizeMap.put(node1, size1 + size2);
            nodeSizeMap.remove(node2);
        } else {
            parentMap.put(node1, node2);
            nodeSizeMap.put(node2, size1 + size2);
            nodeSizeMap.remove(node1);
        }

    }

    public int size() {
        return nodeSizeMap.size();
    }

    public Node findFather(V v) {

        Node node = nodeMap.get(v);
        if (node == null) {
            return null;
        }

        List<Node> list = new ArrayList<>();

        while (parentMap.get(node) != node) {
            node = parentMap.get(node);
            list.add(node);
        }

        for (Node node1 : list) {
            parentMap.put(node1, node);
        }
        return node;
    }


    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());

        UnionFindSet findSet = new UnionFindSet(list);

        findSet.union(1, 3);
        System.out.println(findSet.isSameSet(1, 3));
        findSet.union(2, 4);
        System.out.println(findSet.isSameSet(2, 3));
        findSet.union(1, 4);
        System.out.println(findSet.isSameSet(2, 3));
        System.out.println(findSet.isSameSet(2, 9));

    }
}

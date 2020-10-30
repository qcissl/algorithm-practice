package com.qc.algo.basic.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * description
 *
 * @author qinc 2020/10/29 15:29
 */
public class GraphDFS {

    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Set<Node> set = new HashSet<>();
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            node = stack.pop();
            for (Node next : node.nexts) {
                if (!set.contains(next)) {
                    stack.push(node);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = CheckGraphUtil.matrixDirectCreate(10,100,100);
        System.out.println("matrix:"+matrix.length);
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][1]+"-"+matrix[i][2]);
        }
        Graph graph = GraphGenerator.generator(matrix);
        System.out.println("size:"+graph.nodes.size());
        for(Node node:graph.nodes.values()){
            dfs(node);
            break;
        }
    }
}

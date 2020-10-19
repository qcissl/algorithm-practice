package com.qc.algo.basic.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author qinc 2020/10/17 14:45
 */
public class TrieNode {

    private int pass;
    private int end;
    private Map<Integer, TrieNode> nextNodes;

    public TrieNode() {
        this.nextNodes = new HashMap<>();
    }

    public void passIncrease() {
        pass++;
    }

    public void passReduce() {
        pass--;
    }

    public void endIncrease() {
        end++;
    }

    public void endReduce() {
        end--;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Map<Integer, TrieNode> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(Map<Integer, TrieNode> nextNodes) {
        this.nextNodes = nextNodes;
    }
}

package com.qc.algo.basic.trie;

import java.util.HashMap;

/**
 * description
 *
 * @author qinc 2020/10/17 14:45
 */
public class TrieTree {

    private TrieNode root;

    public TrieTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.passIncrease();
        Integer index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = Integer.valueOf(chars[i]);
            if (!node.getNextNodes().containsKey(index)) {
                node.getNextNodes().put(index, new TrieNode());
            }
            node = node.getNextNodes().get(index);
            node.passIncrease();
        }
        node.endIncrease();
    }

    public void delete(String word) {
        if (search(word) > 0) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.passReduce();
            Integer index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = Integer.valueOf(chars[i]);
                if (node.getNextNodes().get(index).getPass() == 1) {
                    node.getNextNodes().remove(index);
                    return;
                }
                node = node.getNextNodes().get(index);
                node.passReduce();
            }
            node.endReduce();
        }
    }

    public int search(String word) {
        TrieNode node = find(word);
        if (node == null) {
            return 0;
        }
        return node.getEnd();
    }

    public int prefixSize(String word) {
        TrieNode node = find(word);
        if (node == null) {
            return 0;
        }
        return node.getPass();
    }

    public TrieNode find(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        Integer index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = Integer.valueOf(chars[i]);
            if (!node.getNextNodes().containsKey(index)) {
                return null;
            }
            node = node.getNextNodes().get(index);
        }
        return node;
    }

    public static void main(String[] args) {
        int arrLen = 100;
        int strLen = 20;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = generateRandomStringArray(arrLen, strLen);
            TrieTree trie1 = new TrieTree();
            Right right = new Right();
            for (int j = 0; j < arr.length; j++) {
                double decide = Math.random();
                if (decide < 0.25) {
                    trie1.insert(arr[j]);
                    right.insert(arr[j]);
                } else if (decide < 0.5) {
                    trie1.delete(arr[j]);
                    right.delete(arr[j]);
                } else if (decide < 0.75) {
                    int ans1 = trie1.search(arr[j]);
                    int ans3 = right.search(arr[j]);
                    if (ans1 != ans3) {
                        System.out.println("Oops!");
                    }
                } else {
                    int ans1 = trie1.prefixSize(arr[j]);
                    int ans3 = right.prefixNumber(arr[j]);
                    if (ans1 != ans3) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        System.out.println("finish!");
    }

    public static class Right {

        private HashMap<String, Integer> box;

        public Right() {
            box = new HashMap<>();
        }

        public void insert(String word) {
            if (!box.containsKey(word)) {
                box.put(word, 1);
            } else {
                box.put(word, box.get(word) + 1);
            }
        }

        public void delete(String word) {
            if (box.containsKey(word)) {
                if (box.get(word) == 1) {
                    box.remove(word);
                } else {
                    box.put(word, box.get(word) - 1);
                }
            }
        }

        public int search(String word) {
            if (!box.containsKey(word)) {
                return 0;
            } else {
                return box.get(word);
            }
        }

        public int prefixNumber(String pre) {
            int count = 0;
            for (String cur : box.keySet()) {
                if (cur.startsWith(pre)) {
                    count += box.get(cur);
                }
            }
            return count;
        }
    }

    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }
}

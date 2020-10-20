package com.qc.algo.basic.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author qinc 2020/10/20 16:17
 */
public class CopyListWithRandom {

    public static RandomNode right(RandomNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomNode, RandomNode> nodeMap = new HashMap<>();
        RandomNode node = head;
        while (node != null) {
            nodeMap.put(node, new RandomNode(node.getValue()));
            node = node.getNext();
        }

        RandomNode newHead = null;
        node = head;
        while (node != null) {
            newHead = nodeMap.get(node);
            newHead.setNext(nodeMap.get(node.getNext()));
            newHead.setRand(nodeMap.get(node.getRand()));
            node = node.getNext();
            newHead = newHead.getNext();
        }
        return nodeMap.get(head);
    }

    public static RandomNode copyLinkedList(RandomNode head) {
        if (head == null) {
            return head;
        }

        RandomNode node = head;
        while (node != null) {
            insertNewNode(node);
            node = node.getNext().getNext();
        }

        node = head;
        while (node != null) {
            node.getNext().setRand(node.getRand()!=null?node.getRand().getNext():null);
            node = node.getNext().getNext();
        }

        RandomNode newHead = head.getNext();
        RandomNode current = newHead;
        node = head;
        while (node != null) {
            current = removeNextNode(node);
            node = node.getNext();
        }
        return newHead;
    }

    private static RandomNode removeNextNode(RandomNode node) {
        RandomNode next = node.getNext();
        node.setNext(next.getNext());
        next.setNext(node.getNext()!=null?node.getNext().getNext():null);
        return next;
    }

    private static void insertNewNode(RandomNode node) {
        RandomNode next = node.getNext();
        node.setNext(new RandomNode(node.getValue()));
        node.getNext().setNext(next);
    }

    public static void main(String[] args) {
        RandomNode head = null;
        RandomNode res1 = null;
        RandomNode res2 = null;

        head = new RandomNode(1);
        head.next = new RandomNode(2);
        head.next.next = new RandomNode(3);
        head.next.next.next = new RandomNode(4);
        head.next.next.next.next = new RandomNode(5);
        head.next.next.next.next.next = new RandomNode(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        System.out.println("原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");
        res1 = right(head);
        System.out.println("方法一的拷贝链表：");
        printRandLinkedList(res1);
        System.out.println("=========================");
        res2 = copyLinkedList(head);
        System.out.println("方法二的拷贝链表：");
        printRandLinkedList(res2);
        System.out.println("=========================");
        System.out.println("经历方法二拷贝之后的原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");
    }

    public static void printRandLinkedList(RandomNode head) {
        RandomNode cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

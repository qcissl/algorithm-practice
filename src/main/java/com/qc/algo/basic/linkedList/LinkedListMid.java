package com.qc.algo.basic.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author qinc 2020/10/19 14:14
 */
public class LinkedListMid {

    /**
     * 奇数长度返回中点，偶数长度返回上中点
     *
     * @param head
     * @return
     */
    public static Node<Integer> upMid(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node node = head;
        Node fast = node.getNext();
        Node slow = node;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    /**
     * 奇数长度返回中点，偶数长度返回下中点
     * @param head
     * @return
     */
    public static Node downMid(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node node = head;
        Node fast = head.getNext().getNext();
        Node slow = head.getNext();
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    public static Node upMidPre(Node head){
        if (head == null || head.getNext()==null){
            return head;
        }
        Node node = head;
        Node fast = head.getNext().getNext();
        Node slow = head;
        while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    public static Node downMidPre(Node head){
        if (head == null || head.getNext()==null){
            return head;
        }
        Node node = head;
        Node fast = head.getNext();
        Node slow = head;
        while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    public static List<Node> right(Node<Integer> head) {
        List<Node> list = new ArrayList<>();
        Node node = head;
        while (node != null) {
            list.add(node);
            node = node.getNext();
        }
        return list;
    }

    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.setNext(new Node(1));
        test.getNext().setNext(new Node(2));
        test.getNext().getNext().setNext(new Node(3));
        test.getNext().getNext().getNext().setNext(new Node(4));
        test.getNext().getNext().getNext().getNext().setNext(new Node(5));
        test.getNext().getNext().getNext().getNext().getNext().setNext(new Node(6));
        test.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(7));
        test.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(8));
        test.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(9));

        Node ans1 = null;
        Node ans2 = null;

        ans1 = upMid(test);
        List<Node> list = right(test);
        ans2 = list.get((list.size()-1)/2);
        System.out.println(ans1 != null ? ans1.getValue() : "无");
        System.out.println(ans2 != null ? ans2.getValue() : "无");

        System.out.println("-----------------------------");

        ans1 = downMid(test);
        ans2 = list.get((list.size())/2);
        System.out.println(ans1 != null ? ans1.getValue(): "无");
        System.out.println(ans2 != null ? ans2.getValue() : "无");

        System.out.println("-----------------------------");

        ans1 = upMidPre(test);
        ans2 = list.get((list.size()-1)/2-1);
        System.out.println(ans1 != null ? ans1.getValue(): "无");
        System.out.println(ans2 != null ? ans2.getValue() : "无");

        System.out.println("-----------------------------");

        ans1 = downMidPre(test);
        ans2 = list.get((list.size())/2-1);
        System.out.println(ans1 != null ? ans1.getValue(): "无");
        System.out.println(ans2 != null ? ans2.getValue() : "无");
    }
}

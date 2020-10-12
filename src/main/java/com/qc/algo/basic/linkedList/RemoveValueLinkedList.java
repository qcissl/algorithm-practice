package com.qc.algo.basic.linkedList;

/**
 * description
 *
 * @author qinc 2020/10/12 14:02
 */
public class RemoveValueLinkedList {

    /**
     * 删除链表给定值
     *
     * @return
     */
    public static Node<Integer> removeGivenValue(Node<Integer> head, Integer value) {
        while (head != null && head.getValue().intValue() == value.intValue()) {
            head = head.getNext();
        }
        Node<Integer> pre = head;
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue().intValue() != value.intValue()) {
                pre = current;
            }else{
                pre.setNext(current.getNext());
            }
            current = current.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = CheckLinkedList.createSingleList(30, 100);
        Node<Integer> copy = head;
        while (head != null) {
            System.out.print(head.getValue() + ",");
            head = head.getNext();
        }

        System.out.println();
        int value = 22;
        head = removeGivenValue(copy, value);

        while (head != null) {
            System.out.print(head.getValue() + ",");
            head = head.getNext();
        }
    }
}

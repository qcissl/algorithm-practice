package com.qc.algo.basic.linkedList;

/**
 * description
 *
 * @author qinc 2020/10/20 17:52
 */
public class FindFirstIntersectNode {

    public static Node firstIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null || loop2 == null) {
            return noLoop(head1, head2, null);
        } else {
            return bothLoop(head1, loop1, head2, loop2);
        }
    }

    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        if (loop1 == loop2) {
            return noLoop(head1, head2, loop1);
        } else {
            Node node = loop1.getNext();
            while (node != loop1) {
                if (node == loop2) {
                    return loop1;
                }
                node = node.getNext();
            }
            return null;
        }
    }

    private static Node noLoop(Node head1, Node head2, Node stop) {
        int size = 0;
        Node node1 = head1;
        while (node1 != stop) {
            node1 = node1.getNext();
            size++;
        }
        Node node2 = head2;
        while (node2 != stop) {
            node2 = node2.getNext();
            size--;
        }
        node1 = size > 0 ? head1 : head2;
        node2 = size > 0 ? head2 : head1;
        size = Math.abs(size);
        while (size > 0) {
            node1 = node1.getNext();
            size--;
        }
        while (node1 != stop) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.getNext();
            node2 = node2.getNext();
        }
        return null;
    }

    private static Node getLoopNode(Node head) {
        Node fast = head.getNext().getNext();
        Node slow = head.getNext();
        while (fast != null && fast.getNext() != null) {
            if (fast == slow) {
                break;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        if (fast == null || fast.getNext() == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return fast;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(firstIntersectNode(head1,head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(firstIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(firstIntersectNode(head1, head2).value);

    }
}

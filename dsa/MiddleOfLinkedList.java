package ok;

import java.util.LinkedList;

public class MiddleOfLinkedList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        // ListNode l4 = new ListNode(4);
        // ListNode l5 = new ListNode(5);
        // ListNode l6 = new ListNode(6);
        // ListNode l7 = new ListNode(7);

        ListNode l11 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l33 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        // l3.next=l4;
        l11.next = l22;
        l22.next = l33;

        //l4.next=l5;
        //l5.next=l6;
        //l6.next=l7;

        ListNode current = l1;
        ListNode otherCurrent = l11;

        // ListNode test = MiddleNode(current);

        // ListNode test2 = middleNodeWithTwoRef(current);

        ListNode test3 = mergeTwoLists(current, otherCurrent);

        while (test3 != null) {
            System.out.println(test3.val);
            test3 = test3.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            result = l1;
            l1 = l1.next;
        } else {
            result = l2;
            l2 = l2.next;
        }


        ListNode current = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }


        return result;
    }

    public static ListNode middleNodeWithTwoRef(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    public static ListNode MiddleNode(ListNode head) {
        int size = 0;
        ListNode currentNode = head;

        while (currentNode.next != null) {
            size++;
            currentNode = currentNode.next;
        }

        currentNode = head;
        int counter = 0;
        int spins;

        if (size % 2 == 1) {
            spins = (size / 2);
        } else {
            spins = (size / 2) - 1;
        }

        while (counter <= spins) {
            counter++;
            currentNode = currentNode.next;
        }

        return currentNode;
    }
}
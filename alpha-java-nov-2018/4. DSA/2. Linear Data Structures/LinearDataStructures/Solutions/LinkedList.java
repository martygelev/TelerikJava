package com.telerikacademy.tasks.LinearDataStructures.Solutions;

import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode curr = l1;

        ListNode bla = middleNode(l1);

        while (bla != null) {
            System.out.println(bla.val);
            bla = bla.next;
        }


    }

    public static ListNode middleNode1(ListNode head) {
        ListNode current = head;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }

        current = head;
        int i = 0;
        while (current != null && i <= (size / 2) - 1) {
            i++;
            current = current.next;
        }
        return current;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;

        if (l1 == null) {
            return l2;
        }

        ListNode current = result;
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            current = l1;
            l1 = l1.next;
        } else {
            current = l2;
            l2 = l2.next;
        }

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
}
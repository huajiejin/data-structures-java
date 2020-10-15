package io.github.huajiejin.leetcode.linkedlist;

import io.github.huajiejin.datastructuresjava.List;
import io.github.huajiejin.leetcode.util.ListNode;

import java.util.Stack;

public class _234PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode l = ListNode.buildFrom(new int[]{1, 1, 2, 1});
        _234PalindromeLinkedList palindromeLinkedList = new _234PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(l));
        ListNode.println(l);
    }

    public boolean isPalindrome(ListNode head) {
        // return s1(head);
        // return s2(head);
        return s3(head);
    }

    public boolean s3(ListNode head) {
        if (head == null) return true;
        // calculate length of list
        int len = 0;
        for (ListNode i = head; i != null; i = i.next, len++);
        int halfLen = len >> 1;

        // reverse half of the list
        ListNode prev = null;
        for (int i = 0; i < halfLen; i++) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        ListNode FirstHalfReversedHead = prev;
        ListNode secondHalfHead = head;

        // remove if there is a node in the middle of the list
        if (halfLen + halfLen != len) {
            secondHalfHead = secondHalfHead.next;
        }

        // compare
        for (; FirstHalfReversedHead != null && secondHalfHead != null; FirstHalfReversedHead = FirstHalfReversedHead.next, secondHalfHead = secondHalfHead.next) {
            if (FirstHalfReversedHead.val != secondHalfHead.val) return false;
        }

        return true;
    }

    public boolean s2(ListNode head) {
        if (head == null) return true;
        Stack<Integer> stack = new Stack<>();
        // store list in stack
        for (ListNode i = head; i != null; i = i.next) {
            stack.push(i.val);
        }
        // compare
        for (ListNode i = head; i != null; i = i.next) {
            if (i.val != stack.pop()) return false;
        }
        return true;
    }

    public boolean s1(ListNode head) {
        if (head == null) return true;
        ListNode c = clone(head);
        ListNode cr = reverse(head);
        while (c != null) {
            if (c.val != cr.val) return false;
            c = c.next;
            cr = cr.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode clone(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode();
        ListNode c = newHead;
        while (head != null) {
            c.next = new ListNode(head.val);
            head = head.next;
            c = c.next;
        }
        return newHead.next;
    }
}

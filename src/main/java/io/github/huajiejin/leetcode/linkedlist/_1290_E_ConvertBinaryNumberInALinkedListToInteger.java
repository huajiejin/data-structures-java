package io.github.huajiejin.leetcode.linkedlist;

import io.github.huajiejin.leetcode.util.ListNode;

import java.util.ArrayList;

public class _1290_E_ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        _1290_E_ConvertBinaryNumberInALinkedListToInteger instance = new _1290_E_ConvertBinaryNumberInALinkedListToInteger();
        System.out.println(instance.s1(ListNode.buildFrom(new int[]{1,0,0,1})));
        System.out.println(instance.s1(ListNode.buildFrom(new int[]{1,0,0})));
        System.out.println(instance.s1(ListNode.buildFrom(new int[]{1,0})));
        System.out.println(instance.s1(ListNode.buildFrom(new int[]{1})));
        System.out.println(instance.s1(ListNode.buildFrom(new int[]{0})));
    }

    private int s1(ListNode head) {
        int ret = head.val;
        head = head.next;
        while (head != null) {
            ret <<= 1;
            ret += head.val;
            head = head.next;
        }
        return ret;
    }
}

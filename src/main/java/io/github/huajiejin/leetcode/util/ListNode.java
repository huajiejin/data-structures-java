package io.github.huajiejin.leetcode.util;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode buildFrom (int[] array) {
        ListNode ret = new ListNode();
        ListNode c = ret;
        for (int e : array) {
            c.next = new ListNode(e);
            c = c.next;
        }
        return ret.next;
    }

    public static Object[] asArray (ListNode head) {
        List ret = new ArrayList();
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret.toArray();
    }

    public static void println(ListNode head) {
        String s = ReflectionToStringBuilder.toString(ListNode.asArray(head), ToStringStyle.DEFAULT_STYLE);
        System.out.println(s);
    }
}

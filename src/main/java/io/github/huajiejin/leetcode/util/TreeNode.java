package io.github.huajiejin.leetcode.util;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        List<Integer> l = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                l.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            } else {
                l.add(null);
            }
        }
        return l.toString();
    }

    public static TreeNode buildFrom(Integer[] elements) {
        if (elements.length <= 0) return null;
        TreeNode node = new TreeNode(elements[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        for (int i=1; i<elements.length; i+=2) {
            TreeNode curNode = q.poll();
            curNode.left = new TreeNode(elements[i]);
            q.offer(curNode.left);
            if (i+1 < elements.length) {
                curNode.right = new TreeNode(elements[i+1]);
                q.offer(curNode.right);
            }
        }
        return node;
    }
}

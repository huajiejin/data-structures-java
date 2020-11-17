package io.github.huajiejin.leetcode.tree;

import io.github.huajiejin.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_E_BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        _107_E_BinaryTreeLevelOrderTraversalII instance = new _107_E_BinaryTreeLevelOrderTraversalII();
        TreeNode c1 = TreeNode.buildFrom(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(c1);
        System.out.println(instance.s1(c1));
    }

    public List<List<Integer>> s1(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<List<Integer>> l = new LinkedList<>();
        List<Integer> li = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int rowCount = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                rowCount--;
                li.add(node.val);
            }

            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }

            if (rowCount == 0) {
                rowCount = q.size();
                l.addFirst(li);
                li = new LinkedList<>();
            }
        }

        return l;
    }
}

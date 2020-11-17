package io.github.huajiejin.datastructuresjava.tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImpl<E> implements BinarySearchTree<E> {
    private Comparator comparator;
    private int size;
    private Node<E> root;

    public BinarySearchTreeImpl() {}

    public BinarySearchTreeImpl(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        Node<E> parent = root;
        Node<E> node = root;
        int greater = 0;
        while (node != null) {
            // 0 means equal, greater than 0 means element is greater, less than 0 means element is less.
            greater = compare(element, node.element);
            parent = node;
            if (greater > 0) {
                node = node.right;
            } else if (greater < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }
        }
        Node<E> newNode = new Node<>(element, parent);
        if (greater > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) return comparator.compare(e1, e2);
        return ((Comparable<E>) e1).compareTo(e2);
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not null");
        }
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    public static <E> void preOrderTraversal(BinarySearchTreeImpl<E> tree) {
        if (tree == null) return;
        preOrderTraversalExecutor(tree.getRoot());
    }

    private static <E> void preOrderTraversalExecutor(Node<E> root) {
        if (root == null) return;
        System.out.println(root.element);
        preOrderTraversalExecutor(root.left);
        preOrderTraversalExecutor(root.right);
    }

    public static <E> void inOrderTraversal(BinarySearchTreeImpl<E> tree) {
        if (tree == null) return;
        inOrderTraversalExecutor(tree.getRoot());
    }

    private static <E> void inOrderTraversalExecutor(Node<E> root) {
        if (root == null) return;
        inOrderTraversalExecutor(root.left);
        System.out.println(root.element);
        inOrderTraversalExecutor(root.right);
    }

    public static <E> void postOrderTraversal(BinarySearchTreeImpl<E> tree) {
        if (tree == null) return;
        postOrderTraversalExecutor(tree.getRoot());
    }

    private static <E> void postOrderTraversalExecutor(Node<E> root) {
        if (root == null) return;
        postOrderTraversalExecutor(root.left);
        postOrderTraversalExecutor(root.right);
        System.out.println(root.element);
    }

    public static <E> void levelOrderTraversal(BinarySearchTreeImpl<E> tree) {
        if (tree == null) return;
        Queue<Node<E>> q = new LinkedList<>();
        q.add(tree.root);
        while (!q.isEmpty()) {
            Node<E> root = q.poll();
            System.out.println(root.element);
            if (root.left != null) q.add(root.left);
            if (root.right != null) q.add(root.right);
        }
    }

    public static <E> int getHeight(BinarySearchTreeImpl<E> tree) {
        if (tree == null || tree.root == null) return 0;
        int height = 0;
        int rowCount = 1;
        Queue<Node<E>> q = new LinkedList<>();
        q.add(tree.root);
        while (!q.isEmpty()) {
            Node<E> root = q.poll();
            rowCount--;
            if (root.left != null) q.add(root.left);
            if (root.right != null) q.add(root.right);
            if (rowCount == 0) {
                rowCount = q.size();
                height++;
            }
        }
        return height;
    }

    public static <E> boolean isComplete(BinarySearchTreeImpl<E> tree) {
        if (tree == null || tree.getRoot() == null) return false;

        Queue<Node<E>> q = new LinkedList<>();
        q.add(tree.root);
        boolean nonLeaf = false;

        while (!q.isEmpty()) {
            Node<E> node = q.poll();
            if (nonLeaf && BinarySearchTreeImpl.hasLeaf(node)) return false;

            if (node.left != null) {
                q.offer(node.left);
            } else if (node.right != null) {
                return false;
            } else {
                nonLeaf = true;
            }

            if (node.right != null) {
                q.offer(node.right);
            } else {
                nonLeaf = true;
            }
        }

        return true;
    }

    private static <E> boolean hasLeaf(Node<E> node) {
        if (node == null) return true;
        return node.left != null || node.right != null;
    }
}

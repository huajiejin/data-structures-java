import io.github.huajiejin.datastructuresjava.array.Array;
import io.github.huajiejin.datastructuresjava.tree.BinarySearchTree;
import io.github.huajiejin.datastructuresjava.tree.BinarySearchTreeImpl;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class TreeTest {
    @Test
    public void bootstrap() {
        BinarySearchTreeImpl<Integer> bst1 = new BinarySearchTreeImpl<>();
        add(bst1, new Integer[]{1,3,5,2,10,6,4,8});
        System.out.println("preOrderTraversal");
        BinarySearchTreeImpl.preOrderTraversal(bst1);
        System.out.println("inOrderTraversal");
        BinarySearchTreeImpl.inOrderTraversal(bst1);
        System.out.println("postOrderTraversal");
        BinarySearchTreeImpl.postOrderTraversal(bst1);
        System.out.println("levelOrderTraversal");
        BinarySearchTreeImpl.levelOrderTraversal(bst1);
    }

    @Test
    public void getHeight() {
        BinarySearchTreeImpl<Integer> bst1 = new BinarySearchTreeImpl<>();
        add(bst1, new Integer[]{1,3});
        assertEquals("1,3", 2, BinarySearchTreeImpl.getHeight(bst1));
        add(bst1, new Integer[]{5,2,10,6,4,8});
        assertEquals("1,3,5,2,10,6,4,8", 6, BinarySearchTreeImpl.getHeight(bst1));
        add(bst1, new Integer[]{11,12,13});
        assertEquals("1,3,5,2,10,6,4,8,11,12,13", 7, BinarySearchTreeImpl.getHeight(bst1));
    }

    @Test
    public void isComplete() {
        BinarySearchTreeImpl<Integer> bst1 = new BinarySearchTreeImpl<>();
        add(bst1, new Integer[]{5,3,9,2,4,7});
        assertEquals("5,3,9,2,4,7", true, BinarySearchTreeImpl.isComplete(bst1));
        add(bst1, new Integer[]{1});
        assertEquals("5,3,9,2,4,7,1", false, BinarySearchTreeImpl.isComplete(bst1));
        add(bst1, new Integer[]{10});
        assertEquals("5,3,9,2,4,7,1,10", true, BinarySearchTreeImpl.isComplete(bst1));
    }

    private <E extends Comparable> void add(BinarySearchTree<E> bst, E[] arr) {
        for (int i=0; i<arr.length; i++) {
            bst.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        boolean[] l = new boolean[256];
        char a = 'a';
        l[a] = true;
        System.out.println(ReflectionToStringBuilder.toString(l));
        System.out.println((int) 'z');
        // char[] chars = {'c', 'b', 'a', 'e', 'd'};
        // Arrays.sort(chars);
        // System.out.println(ReflectionToStringBuilder.toString(chars));
        // System.out.println("abc".compareTo("abbc"));
        // System.out.println("aabbc".compareTo("abbc"));
        // System.out.println("adabbc".compareTo("adabbc"));
    }
}

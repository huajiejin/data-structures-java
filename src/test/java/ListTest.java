import io.github.huajiejin.datastructuresjava.List;
import io.github.huajiejin.datastructuresjava.array.DynamicArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import io.github.huajiejin.datastructuresjava.linkedlist.LinkedList;
import io.github.huajiejin.datastructuresjava.linkedlist.LinkedListWithVirtualHead;
import org.junit.Test;

public class ListTest {
    @Test
    public void main() {
        List<Integer> list1 = new DynamicArray<>();
        List<Integer> list2 = new DynamicArray<>(1);
        List<Integer> list3 = new DynamicArray<>(0);
        List<Integer> list4 = new LinkedList<>();
        List<Integer> list5 = new LinkedListWithVirtualHead<>();
        testInterfaces(list1);
        testInterfaces(list2);
        testInterfaces(list3);
        testInterfaces(list4);
        testInterfaces(list5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        List emptyList = new DynamicArray();
        Object o = emptyList.get(0);
    }

    public void testInterfaces(List<Integer> list) {
        // size
        assertEquals("After creation", 0, list.size());
        // first element is null
        list.add(null);
        assertEquals("first element is null", 0, list.indexOf(null));
        list.clear();
        // add
        list.add(1);
        assertEquals("After adding 1 time", 1, list.size());
        // insertAt
        list.insertAt(0, 12);
        assertEquals("After adding at index 0", 2, list.size());
        // get
        assertEquals("The element with index 1 should be 1", 1, ((int) list.get(1)));
        // set
        list.set(0, 0);
        assertEquals("The element with index 0 should be 0", 0, ((int) list.get(0)));
        // contains
        assertTrue("Should contains 1", list.contains(1));
        // indexOf
        list.add(null);
        assertEquals("Element null should be at index 2", 2, list.indexOf(null));
        list.remove(2);
        assertEquals("Element 0 should be at index 0", 0, list.indexOf(0));
        assertEquals("Element 1 should be at index 1", 1, list.indexOf(1));
        assertEquals("Element -10 should not exist", List.ELEMENT_NOT_FOUND, list.indexOf(-10));
        // remove
        list.remove(1);
        assertEquals("After removing at index 1", 1, list.size());
        // isEmpty
        assertFalse("The list should not be empty", list.isEmpty());
        // remove 0
        list.remove(0);
        assertEquals("After removing at index 0", 0, list.size());
        // clear
        list.add(888);
        list.clear();
        assertTrue("After clearing the list", list.isEmpty());
    }
}

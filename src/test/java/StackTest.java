import io.github.huajiejin.datastructuresjava.stack.Stack;
import org.junit.Test;

import static java.util.Optional.ofNullable;
import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void bootstrap() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        assertEquals("peek should return the last element", 1, (int) s.peek());
        s.push(2);
        assertEquals("peek should return the last element", 2, (int) s.peek());
        assertEquals("pop should return and remove the last element", 2, (int) s.pop());
        assertEquals("peek should return the last element", 1, (int) s.peek());
        assertEquals("pop should return and remove the last element", 1, (int) s.pop());
        assertEquals("pop should return and remove the last element", null, s.pop());
        assertEquals("peek should return the last element", null, s.peek());
    }

}

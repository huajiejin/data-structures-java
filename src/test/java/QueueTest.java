import io.github.huajiejin.datastructuresjava.queue.Queue;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QueueTest {

    @Test
    public void bootstrap() {
        Queue<Integer> q = new Queue<>();
        q.enQueue(1);
        assertEquals("front should be 1", 1, (int) q.front());
        q.enQueue(2);
        assertEquals("deQueue should return 2", 2, (int) q.deQueue());
        assertEquals("deQueue should remove 2", 1, (int) q.front());
    }
}

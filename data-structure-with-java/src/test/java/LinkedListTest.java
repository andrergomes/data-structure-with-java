import br.com.andrergomes.linkedList.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private static final int DEFAULT_VALUE = 4;
    private LinkedList linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new LinkedList(DEFAULT_VALUE);
    }

    @Test
    void testNewLinkedList() {
        assertEquals(linkedList.getLength(), 1);
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertNull(linkedList.getHead().getNext());
        assertNull(linkedList.getTail().getNext());
    }

    @Test
    void testAppendValue() {
        linkedList.append(11);

        assertEquals(linkedList.getLength(), 2);
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(4, linkedList.getHead().getValue());
        assertEquals(11, linkedList.getTail().getValue());
    }

    @Test
    void testRemoveLastValue() {
        linkedList.append(11);

        LinkedList.Node nodeRemoved = linkedList.removeLast();

        assertEquals(11, nodeRemoved.getValue());
        assertEquals(linkedList.getLength(), 1);
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(4, linkedList.getHead().getValue());
        assertEquals(4, linkedList.getTail().getValue());
    }
}

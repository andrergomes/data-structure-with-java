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
        assertEquals(1, linkedList.getLength());
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(4, linkedList.getHead().getValue());
        assertEquals(4, linkedList.getTail().getValue());
    }

    @Test
    void testPrependValue() {
        linkedList.prepend(2);

        assertEquals(2, linkedList.getLength());
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(2, linkedList.getHead().getValue());
        assertEquals(4, linkedList.getTail().getValue());
    }

    @Test
    void testRemoveFirstValue() {
        linkedList.append(1);

        LinkedList.Node removedValue = linkedList.removeFirst();

        assertNotNull(removedValue);
        assertEquals(4, removedValue.getValue());
        assertEquals(1, linkedList.getLength());
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(1, linkedList.getHead().getValue());
        assertEquals(1, linkedList.getTail().getValue());
    }

    @Test
    void testGetByIndex() {
        linkedList.append(1); // Index: 1

        linkedList.append(5); // Index: 2

        linkedList.append(3); // Index: 3

        LinkedList.Node foundNode = linkedList.get(2);

        assertNotNull(foundNode);
        assertEquals(5, foundNode.getValue());
    }

    @Test
    void testSetValueByIndex() {
        linkedList.append(1); // Index: 1

        linkedList.append(5); // Index: 2

        linkedList.append(3); // Index: 3

        boolean changedValue = linkedList.set(2, 6);

        assertTrue(changedValue);
        assertNotNull(linkedList.get(2));
        assertEquals(6, linkedList.get(2).getValue());
    }
}

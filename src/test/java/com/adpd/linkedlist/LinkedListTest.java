package com.adpd.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinkedListTest {

    private LinkedList linkedList;

    @BeforeEach
    void initLinkedList() {
        linkedList = new LinkedList(1);
    }

    @Test
    void testSingleElementList() {
        assertHeadTailLength(1, 1, 1);
    }

    @Test
    void testPrintList() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        linkedList.append(2);
        linkedList.append(3);
        linkedList.printList();

        assertEquals("LinkedList: 1, 2, 3", outputStreamCaptor.toString().trim());
        System.setOut(System.out);
    }

    @Test
    void testAppendSingleElement() {
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        assertHeadTailLength(1, 4, 4);
    }

    @Test
    void testRemoveLastFromMultipleElementList() {
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        Integer removed = linkedList.removeLast();

        assertEquals(4, removed);
        assertHeadTailLength(1, 3, 3);
    }

    @Test
    void testRemoveLastFromSingleElementList() {
        Integer removedElement1 = linkedList.removeLast();
        assertEquals(1, removedElement1);
        assertHeadTailLength(null, null, 0);

        Integer removedElement2 = linkedList.removeLast();
        assertNull(removedElement2);
        assertHeadTailLength(null, null, 0);
    }

    @Test
    void testPrepend() {
        linkedList.removeLast();
        assertHeadTailLength(null, null, 0);

        linkedList.prepend(20);
        assertHeadTailLength(20, 20, 1);

        linkedList.append(10);
        linkedList.prepend(30);
        linkedList.prepend(40);
        assertHeadTailLength(40, 10, 4);
    }

    @Test
    void testRemoveFirstFromMultipleElementList() {
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        Integer removed = linkedList.removeFirst();

        assertEquals(1, removed);
        assertHeadTailLength(2, 4, 3);
    }

    @Test
    void testRemoveFirstFromSingleElementList() {
        Integer removedElement1 = linkedList.removeFirst();
        assertEquals(1, removedElement1);
        assertHeadTailLength(null, null, 0);

        Integer removedElement2 = linkedList.removeFirst();
        assertNull(removedElement2);
        assertHeadTailLength(null, null, 0);
    }

    @Test
    void testGetElementByIndex() {
        linkedList.append(2);
        linkedList.append(3);

        assertNull(linkedList.get(-1));
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
        assertNull(linkedList.get(3));
        assertHeadTailLength(1, 3, 3);
    }

    @Test
    void testSetValueByIndex() {
        linkedList.append(2);
        linkedList.append(3);

        linkedList.set(-1, 2);
        linkedList.set(0, 6);
        linkedList.set(1, 7);
        linkedList.set(3, 8);

        assertNull(linkedList.get(-1));
        assertEquals(6, linkedList.get(0));
        assertEquals(7, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
        assertNull(linkedList.get(3));
        assertHeadTailLength(6, 3, 3);
    }

    private void assertHeadTailLength(Integer head, Integer tail, int length) {
        assertEquals(head, linkedList.getHead());
        assertEquals(tail, linkedList.getTail());
        assertEquals(length, linkedList.getLength());
    }
}

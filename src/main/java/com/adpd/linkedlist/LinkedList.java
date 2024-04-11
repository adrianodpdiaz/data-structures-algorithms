package com.adpd.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    private static class Node {

        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if(length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;

        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Integer removeLast() {
        // Empty list
        if (length == 0) {
            return null;
        }

        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;

        // Single element list
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp.value;
    }

    public Integer removeFirst() {
        if (length == 0) {
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        // Single element list
        // head.next is already null
        if (length == 0) {
            tail = null;
        }
        return temp.value;
    }

    public Integer get(int index) {
        if(index < 0 ||index >= length) {
            return null;
        }

        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public void set(int index, int value) {
        if(index < 0 ||index >= length) {
            return;
        }

        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = value;
    }

    public void printList() {
        Node temp = head;

        StringBuilder sb = new StringBuilder("LinkedList: ");
        while (temp != null) {
            sb.append(temp.value);
            if (temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        System.out.println(sb);
    }

    public Integer getHead() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public Integer getTail() {
        if (tail == null) {
            return null;
        }
        return tail.value;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return String.format("Head: %s - Tail: %s - Length: %s", getHead(), getTail(), getLength());
    }
}

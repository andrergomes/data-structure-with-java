package br.com.andrergomes.linkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public Node get(int index) {
        if(index < 0 || index >= this.length) {
            return null;
        }

        Node foundNode = this.head;

        for(int i = 0; i < index; i++) {
            foundNode = foundNode.next;
        }

        return foundNode;
    }

    public boolean set(int index, int value) {
        Node foundNode = get(index);

        if(foundNode != null) {
            foundNode.value = value;
            return true;
        }

        return false;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;

        } else {
            newNode.next = head;
            head = newNode;
        }

        this.length += 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if(this.length == 0) {
            this.head = newNode;

        } else {
            this.tail.next = newNode;
        }

        this.tail = newNode;
        this.length += 1;
    }

    public Node removeFirst() {
        if(this.length == 0) return null;

        Node removedNode = this.head;
        this.head = this.head.next;
        removedNode.next = null;
        this.length -= 1;

        if(this.length == 0) {
            this.tail = null;
        }

        return removedNode;
    }

    public Node removeLast() {
        if(this.length == 0) {
            return null;

        } else {
            Node pre = this.getHead();
            Node temp = this.getHead();

            while(temp.next != null) {
                pre = temp;
                temp = temp.next;
            }

            tail = pre;
            tail.next = null;

            this.length -= 1;

            if(this.length == 0) {
                this.head = null;
                this.tail = null;
            }

            return temp;
        }
    }

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }
}

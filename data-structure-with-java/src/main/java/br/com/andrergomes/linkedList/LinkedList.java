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

        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length -= 1;

        if(this.length == 0) {
            this.tail = null;
        }

        return temp;
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

    public boolean insert(int index, int value) {
        if(index < 0 || index > this.length) return false;

        if(index == 0) {
            prepend(value);
            return true;
        }

        if(index == this.length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = this.get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;

        this.length += 1;

        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= this.length) return null;

        if(index == 0) return removeFirst();

        if(index == this.length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;

        this.length -= 1;

        return temp;
    }

    public void reverse() {

        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        Node before = null;
        Node after = temp.next;

        for(int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
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

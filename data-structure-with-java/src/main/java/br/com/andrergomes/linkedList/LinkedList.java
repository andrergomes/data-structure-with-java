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

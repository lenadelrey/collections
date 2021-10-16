package com.company.stack;

import java.util.Iterator;

public class LinkedStack implements Stack {
    private Node root;
    private int size = 0;

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("hello 1");
        linkedStack.push("hello 2");
        linkedStack.push("hello 3");
        linkedStack.push("hello 4");
        linkedStack.push("hello 5");

        for (Object o : linkedStack) {
            System.out.println(o);
        }
    }

    @Override
    public Object push(Object o) {
        if(empty()) {
            this.root = new Node(o, null);
        } else {
            this.root = new Node(o, this.root);
        }
        size++;
        return this.root;
    }

    @Override
    public Object pop() {
        Node root = this.root;
        this.root = root.next;
        Object old = root.o;
        root.o = null;
        root.next = null;
        size--;
        return old;
    }

    @Override
    public Object peek() {
        return root.o;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int search(Object o) {
        Node temp = this.root;
        int count = 0;
        while (temp.next != null) {
            if(temp.o == o) {
                return count;
            }
            count++;
            temp = temp.next;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "LinkedStack{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator{
        Node cursor = root;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Object next() {
            Object old = cursor.o;
            cursor = cursor.next;
           return old;
        }
    }

    private static class Node {
        Object o;
        Node next;

        public Node(Object o, Node next) {
            this.o = o;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "o=" + o +
                    ", next=" + next +
                    '}';
        }
    }
}

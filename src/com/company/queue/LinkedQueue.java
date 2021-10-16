package com.company.queue;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public static void main(String[] args) {
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.add("Hello 1");
        linkedQueue.add("Hello 2");
        linkedQueue.add("Hello 3");
        linkedQueue.add("Hello 4");

        for (Object o : linkedQueue) {
            System.out.println(o);
        }
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean add(T o) {
        if (empty()) {
            head = tail = new Node<>(o, null);
        } else {
            Node<T> next = new Node<>(o, null);
            tail.next = next;
            this.tail = next;
        }
        size++;
        return true;
    }

    @Override
    public boolean offer(T o) {
        if (empty()) {
            head = tail = new Node<>(o, null);
        } else {
            Node<T> next = new Node<>(o, null);
            tail.next = next;
            this.tail = next;
        }
        size++;
        return true;
    }

    @Override
    public T remove() {
        if (head == tail) {
            T old = head.o;
            this.head = this.tail = null;
            size--;
            return old;
        } else {
            T old = head.o;
            this.head = head.next;
            size--;
            return old;
        }
    }

    @Override
    public T poll() {
        if (head == tail) {
            T old = head.o;
            this.head = this.tail = null;
            size--;
            return old;
        } else {
            T old = head.o;
            this.head = head.next;
            size--;
            return old;
        }
    }

    @Override
    public T element() {
        return head.o;
    }

    @Override
    public T peek() {
        return head.o;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T>{
        Node<T> cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T old = cursor.o;
            cursor = cursor.next;
            return old;
        }
    }

    private static class Node<T> {
        T o;
        Node<T> next;

        public Node(T o, Node<T> next) {
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

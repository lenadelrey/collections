package com.company.list;

import java.util.Iterator;

public class LinkedDeqList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public static void main(String[] args) {
        LinkedDeqList<String> linkedDeqList = new LinkedDeqList<>();
        linkedDeqList.add("Hello 1");
        linkedDeqList.add("Hello 2");
        linkedDeqList.add("Hello 3");
        linkedDeqList.add("Hello 4");
        linkedDeqList.add("Hello 5");

        for (Object o : linkedDeqList) {
            System.out.println(o);
        }
    }

    @Override
    public void add(T o) {
        if (isEmpty()) {
            head = tail = new Node<>(o, null, null);
        } else {
            Node<T> next = new Node<>(o, null, tail);
            tail.next = next;
            this.tail = next;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < index / 2) {
            Node<T> temp = this.head;
            int count = 0;
            while (temp != null) {
                if (count == index) {
                    return temp.o;
                }
                count++;
                temp = temp.next;
            }
        } else {
            Node<T> temp = this.tail;
            int count = size;
            do {
                if (count == index) {
                    return temp.o;
                }
                count--;
                temp = temp.prev;
            }
            while (temp != head);
        }
        return null;
    }

    @Override
    public T delete(int index) {
        if (index <= index / 2) {
            Node<T> temp = this.head;
            int count = 0;
            while (temp != null) {
                if (count == index) {
                    Node<T> left = temp.prev;
                    T old = temp.o;
                    Node<T> right = temp.next;
                    if (left == null) {
                        head = temp.next;
                        temp.next = null;
                    } else {
                        left.next = right;
                    }

                    temp.prev = temp.next = null;
                    temp.o = null;
                    size--;
                    return old;
                }
                count++;
                temp = temp.next;
            }
        } else {
            Node<T> temp = this.tail;
            int count = size - 1;
            do {
                    if (count == index) {
                        Node<T> left = temp.prev;
                        Node<T> right = temp.next;
                        left.next = right;
                        T old = temp.o;
                        if(right == null) {
                            tail = temp.prev;
                            temp.prev = null;
                        } else {
                            right.prev = left;
                        }
                        temp.prev = temp.next = null;
                        temp.o = null;
                        size--;
                        return old;
                    }
                count--;
                temp = temp.prev;
            }
            while (temp != head);
        }
        return null;
    }

    @Override
    public T set(int index, T o) {
        if (index < index / 2) {
            Node<T> temp = this.head;
            int count = 0;
            while (temp != null) {
                if (count == index) {
                    temp.o = o;
                }
                count++;
                temp = temp.next;
            }
        } else {
            Node<T> temp = this.tail;
            int count = size;
            do {
                if (count == index) {
                    temp.o = o;
                }
                count--;
                temp = temp.prev;
            }
            while (temp != head);
        }
        return null;
    }

    @Override
    public void add(int index, T o) {
        if (index < index / 2) {
            Node<T> temp = this.head;
            int count = 0;
            while (temp != null) {
                if (count == index) {
                    temp = new Node<>(o, temp.next, temp.prev);
                }
                count++;
                temp = temp.next;
            }
        } else {
            Node<T> temp = this.tail;
            int count = size;
            do {
                if (count == index) {
                    temp = new Node<>(o, temp.next, temp.prev);
                }
                count--;
                temp = temp.prev;
            }
            while (temp != head);
        }
    }

    @Override
    public boolean contains(T o) {
        Node<T> temp = this.head;
        while (temp != null) {
            if (temp.o == o) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> temp = this.head;
        for (int i = 0; i < size; i++) {
            array[i] = temp.o;
            temp = temp.next;
        }
        return array;
    }

    @Override
    public String toString() {
        return "LinkedDeqList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
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
        Node<T> prev;

        public Node(T o, Node<T> next, Node<T> prev) {
            this.o = o;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "o=" + o +
                    ", next=" + next +
//                    ", prev=" + prev +
                    '}';
        }
    }
}

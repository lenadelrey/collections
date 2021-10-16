package com.company.list;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
    private Node<T> root;
    private int size = 0;

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Hello 1");
        linkedList.add("Hello 2");
        linkedList.add("Hello 3");
        linkedList.add("Hello 4");
        linkedList.add("Hello 5");

        for (Object o : linkedList) {
            System.out.println(o);
        }
    }

    @Override
    public void add(T o) {
        if (isEmpty()) {
            this.root = new Node<>(o, null);
        } else {
            Node<T> temp = this.root;
            while (true) {
                if (temp.next == null) {
                    temp.next = new Node<>(o, null);
                    break;
                }
                temp = temp.next;
            }
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> temp = this.root;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.o;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public T delete(int index) {
        Node<T> temp = this.root;
        int count = 0;
        while (temp != null) {
            if (count == index - 1) {
                temp.next = temp.next.next;
                size--;
                break;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public T set(int index, T o) {
        Node<T> temp = this.root;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                temp.o = o;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public void add(int index, T o) {
        Node<T> temp = this.root;
        int count = 0;
        while (temp != null) {
            if (count == index - 1) {
                Node<T> left = temp;
                Node<T> right = temp.next;
                left.next = new Node<>(o, right);
                size++;
                break;
            }
            count++;
            temp = temp.next;
        }
    }

    @Override
    public boolean contains(T o) {
        Node<T> temp = this.root;
        while (temp != null) {
            if (temp.o.equals(o)) {
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
        int newSize = 0;
        Node<T> temp = this.root;
        while (temp != null) {
            array[newSize++] = temp.o;
            temp = temp.next;
        }
        return array;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "root=" + root +
                ", size=" + size +
                '}';
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

    private class Itr implements Iterator<T> {
        Node<T> cursor = root;

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
}

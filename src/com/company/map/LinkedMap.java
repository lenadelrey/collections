package com.company.map;

import java.util.Arrays;

public class LinkedMap implements Map {
    private Node head;
    private Node tail;
    private int size = 0;

    public static void main(String[] args) {
        LinkedMap linkedMap = new LinkedMap();
        linkedMap.put(1, "Hello 1");
        linkedMap.put(2, "Hello 2");
        linkedMap.put(3, "Hello 3");
        linkedMap.put(4, "Hello 4");
        linkedMap.put(5, "Hello 5");

        System.out.println(linkedMap);
        System.out.println(linkedMap.get(2));
        linkedMap.remove(5);
        System.out.println(linkedMap);
        linkedMap.put(6, "Hello 6");
        System.out.println(linkedMap);
        System.out.println(Arrays.toString(linkedMap.entries()));
    }


    @Override
    public Object put(Object key, Object value) {
        Node temp = this.head;
        if (size == 0) {
            head = tail = new Node(key, value, null, null);
        } else {
            while (temp != null) {
                if (temp.key.equals(key)) {
                    Object old = temp.value;
                    temp.setValue(value);
                    return old;
                }
                temp = temp.next;
            }
            Node next = new Node(key, value, null, tail);
            this.tail.next = next;
            this.tail = next;
        }
        size++;
        return value;
    }

    @Override
    public Object remove(Object key) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                Node left = temp.prev;
                Object old = temp.value;
                Node right = temp.next;
                if (left == null) {
                    head = right;
                    temp.next = null;
                } else {
                    tail = left;
                    left.next = right;
                }
                temp.key = temp.value = temp.next = temp.prev = null;
                size--;
                return old;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public Object get(Object key) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.value.equals(value)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public Object[] keys() {
        Node temp = this.head;
        Object[] array = new Object[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = temp.key;
            temp = temp.next;
        }
        return array;
    }

    @Override
    public Object[] values() {
        Node temp = this.head;
        Object[] array = new Object[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = temp.value;
            temp = temp.next;
        }
        return array;
    }

    @Override
    public Entry[] entries() {
        Entry[] array = new Entry[size];
        Node temp = this.head;
        for (int i = 0; i < array.length; i++) {
            array[i] = new Entry(temp.key, temp.value);
            temp = temp.next;
        }
        return array;
    }

    private static class Node implements Map.Entry {
        Object key;
        Object value;
        Node next;
        Node prev;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node(Object key, Object value, Node next, Node prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            Object old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    //  ", prev=" + prev +
                    '}';
        }
    }

    private static class Entry implements Map.Entry {
        Object key;
        Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            Object old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LinkedMap{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

}

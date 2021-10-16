package com.company.deque;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayDeque implements Deque {
    private Object[] array = new Object[10];
    private int size = 0;

    private int head;
    private int tail;

    public static void main(String[] args) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast("Hello 1");
        arrayDeque.addLast("Hello 2");
        arrayDeque.addLast("Hello 3");
        arrayDeque.addLast("Hello 4");

        for (Object o : arrayDeque) {
            System.out.println(o);
        }
    }

    @Override
    public boolean addFirst(Object o) {
        if (size == array.length) throw new IllegalStateException();
        if(head == 0 && array[array.length - 1] == null) {
            head = array.length;
        }
        array[--head] = o;
        size++;
        return false;
    }

    @Override
    public boolean addLast(Object o) {
        if (size == array.length) throw new IllegalStateException();
        if (tail == array.length && array[0] == null){
            tail = 0;
        }
        array[tail++] = o;
        size++;
        return true;
    }

    @Override
    public boolean offerFirst(Object o) {
        if (size == array.length) return false;
        if(head == 0 && array[array.length - 1] == null) {
            head = array.length;
        }
        array[--head] = o;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(Object o) {
        if (size == array.length) return false;
        if (tail == array.length && array[0] == null){
            tail = 0;
        }
        array[tail++] = o;
        size++;
        return true;
    }

    @Override
    public Object removeFirst() {
        if(head == array.length) {
            head = 0;
        }
        Object o = array[head];
        array[head++] = null;
        size--;
        return o;
    }

    @Override
    public Object removeLast() {
        if(tail == 0) {
            tail = array.length;
        }
        Object o = array[tail - 1];
        array[--tail] = null;
        size--;
        return o;
    }

    @Override
    public Object pollFirst() {
        if(head == array.length) {
            head = 0;
        }
        Object o = array[head];
        array[head++] = null;
        size--;
        return o;
    }

    @Override
    public Object pollLast() {
        if(tail == 0) {
            tail = array.length;
        }
        Object o = array[tail - 1];
        array[--tail] = null;
        size--;
        return o;
    }

    @Override
    public Object elementFirst() {
        if(size == 0) {
            throw new IllegalStateException();
        } else {
            return array[head];
        }
    }

    @Override
    public Object elementLast() {
        if(size == 0) {
            throw new IllegalStateException();
        } else {
            return array[tail];
        }
    }

    @Override
    public Object peekFirst() {
        if(size == 0) {
            return null;
        } else {
            return array[head];
        }
    }

    @Override
    public Object peekLast() {
        if(size == 0) {
            return null;
        } else {
            return array[tail];
        }
    }

    @Override
    public boolean add(Object o) {
        if (size == array.length) throw new IllegalStateException();
        if (tail == array.length && array[0] == null){
            tail = 0;
        }
        array[tail++] = o;
        size++;
        return true;
    }

    @Override
    public boolean offer(Object o) {
        if (size == array.length) return false;
        if (tail == array.length && array[0] == null){
            tail = 0;
        }
        array[tail++] = o;
        size++;
        return true;
    }

    @Override
    public Object remove() {
        if(head == array.length) {
            head = 0;
        }
        Object o = array[head];
        array[head++] = null;
        size--;
        return o;
    }

    @Override
    public Object poll() {
        if(head == array.length) {
            head = 0;
        }
        Object o = array[head];
        array[head++] = null;
        size--;
        return o;
    }

    @Override
    public Object element() {
        if(size == 0) {
            throw new IllegalStateException();
        } else {
            return array[head];
        }
    }

    @Override
    public Object push(Object o) {
        if (size == array.length) throw new IllegalStateException();
        if(head == 0 && array[array.length - 1] == null) {
            head = array.length;
        }
        array[--head] = o;
        size++;
        return o;
    }

    @Override
    public Object pop() {
        if(head == array.length) {
            head = 0;
        }
        Object o = array[head];
        array[head++] = null;
        size--;
        return o;
    }

    @Override
    public Object peek() {
        if(size == 0) {
            throw new IllegalStateException();
        } else {
            return array[head];
        }
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int search(Object o) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayDeque{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", head=" + head +
//                ", tail=" + tail +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator{
        Object[] arr = array;
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return arr[cursor] != null;
        }

        @Override
        public Object next() {
            return arr[cursor++];
        }
    }
}

package com.company.queue;

import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T> {
    private T[] array = (T[]) new Object[10];
    private int size = 0;

    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.add("Hello 1");
        arrayQueue.add("Hello 2");
        arrayQueue.add("Hello 3");
        arrayQueue.add("Hello 4");
        arrayQueue.add("Hello 5");

        for (Object o : arrayQueue) {
            System.out.println(o);
        }
    }

    @Override
    public boolean add(T o) {//IllegalStateException
        if (size == array.length){
            throw new IllegalStateException();
        } else {
            array[size++] = o;
        }
        return true;
    }

    @Override
    public boolean offer(T o) {
        if (size == array.length){
            return false;
        } else {
            array[size++] = o;
        }
        return true;
    }

    @Override
    public T remove() {//if size == 0
        if(size == 0) {
            throw new IllegalStateException();
        } else {
            T old = array[0];
            for (int i = 0; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            return old;
        }
    }

    @Override
    public T poll() {
        T old = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        return old;
    }

    @Override
    public T element() {//if size == 0 exc
        if(size == 0) {
            throw new IllegalStateException();
        } else {
            return array[0];
        }
    }

    @Override
    public T peek() {
        return array[0];
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
        return new Itr<>();
    }

    private class Itr<T> implements Iterator<T>{
        T[] arr = (T[]) array;
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return arr[cursor] != null;
        }

        @Override
        public T next() {
            return arr[cursor++];
        }
    }
}

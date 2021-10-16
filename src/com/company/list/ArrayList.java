package com.company.list;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> implements List<T> {
    private T[] array;
    private int size = 0;

    public ArrayList() {
        this.array = (T[]) new Object[10];
    }

    public ArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello 1");
        arrayList.add("Hello 2");
        arrayList.add("Hello 3");
        arrayList.add("Hello 4");
        arrayList.add("Hello 5");
        arrayList.add("Hello 6");
        arrayList.add("Hello 7");
        arrayList.add("Hello 8");
        arrayList.add("Hello 9");
        arrayList.add("Hello 10");
        arrayList.add("Hello 11");

        for (Object o : arrayList) {
            System.out.println(o);
        }
    }

    private void grow() {
        int i = array.length + (array.length / 2);
        T[] newArray = (T[]) new Object[i];
        for (int j = 0; j < array.length; j++) {
            newArray[j] = array[j];
        }
        this.array = newArray;
    }

    @Override
    public void add(T o) {
        if(size == array.length) {
            grow();
        }
        array[size++] = o;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T delete(int index) {
        for (int i = 0; i < array.length; i++) {
            T old = array[i];
            if (i == index) {
                for (int j = 0; j < size - 1; j++) {
                    array[i] = array[i + 1];
                }
                size--;
                return old;
            }
        }
        return null;
    }

    @Override
    public T set(int index, T o) {
        T old = array[index];
        array[index] = o;
        return null;
    }

    @Override
    public void add(int index, T o) {
        if(size == array.length) {
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = o;
    }

    @Override
    public boolean contains(T o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == o)
                return true;
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
        T[] mas = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            mas[i] = array[i];
        }
        return mas;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T>{
        T[] arr = array;
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

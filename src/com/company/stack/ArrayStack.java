package com.company.stack;

import java.util.Iterator;

public class ArrayStack implements Stack {
    private Object[] objects;
    private int size = 0;

    private ArrayStack() {
        this.objects = new Object[10];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("Hello 1");
        arrayStack.push("Hello 2");
        arrayStack.push("Hello 3");
        arrayStack.push("Hello 4");
        arrayStack.push("Hello 5");

//        Iterator iterator = arrayStack.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        for (Object o : arrayStack) {
            System.out.println(o);
        }
    }

    @Override
    public Object push(Object o) {
        objects[size++] = o;
        return o;
    }

    @Override
    public Object pop() {
        Object old = objects[size - 1];
        objects[size - 1] = null;
        size--;
        return old;
    }

    @Override
    public Object peek() {
        return objects[size - 1];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int search(Object o) {
        for (int i = 0; i < objects.length; i++) {
            if(objects[i] == o) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator{
        Object[] arr = objects;
        int cursor = size - 1;

        @Override
        public boolean hasNext() {
            if (cursor == -1) return false;
            return arr[cursor] != null;
        }

        @Override
        public Object next() {
                return arr[cursor--];
        }
    }
}

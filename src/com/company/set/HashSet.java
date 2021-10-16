package com.company.set;

import com.company.map.HashMap;
import com.company.map.Map;

import java.util.Arrays;

public class HashSet implements Set {
    private static Object mock = new Object();
    private Map map = new HashMap();
    private int size = 0;

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("Hello 1");
        hashSet.add("Hello 2");
        hashSet.add("Hello 3");
        hashSet.add("Hello 1");
        hashSet.add("Hello 4");
        hashSet.add("Hello 5");
        System.out.println(hashSet);
    }

    @Override
    public String toString() {
        return "HashSet{" +
                "map=" + Arrays.toString(map.entries()) +
                ", size=" + size +
                '}';
    }

    @Override
    public void add(Object ob) {
        if (!contains(ob)) {
            map.put(ob, mock);
            size++;
        }
    }

    @Override
    public Object remove(Object ob) {
        map.remove(ob);
        return ob;
    }

    @Override
    public Object[] toArray() {
        return map.keys();
    }

    @Override
    public boolean contains(Object ob) {
        return map.containsKey(ob);
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
    public Object first() {
        Object[] objects = map.keys();
        return objects[0];
    }

    @Override
    public Object last() {
        Object[] objects = map.keys();
        return objects[size - 1];
    }
}

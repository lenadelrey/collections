package com.company.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreeMap implements Map {
    private Entry root;
    private int size = 0;
    private Comparator comparator;
    private List<Entry> entries = new ArrayList<>();

    public TreeMap(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(Integer::compareTo);
        treeMap.put(50, "Hello 50");
        treeMap.put(25, "Hello 25");
        treeMap.put(70, "Hello 70");
        treeMap.put(60, "Hello 60");
        treeMap.put(30, "Hello 30");
        treeMap.put(9, "Hello 9");
        treeMap.put(80, "Hello 80");

        System.out.println(treeMap.get(60));
        System.out.println(treeMap);
        System.out.println(treeMap.remove(70));
        System.out.println(treeMap);
    }

    @Override
    public Object put(Object key, Object value) {
        if(size == 0) {
            Entry root = new Entry(key, value, null, null, null);
            this.root = root;
            entries.add(root);
        } else {
            Entry temp = this.root;
            while (true){
                if (comparator.compare(temp.key, key) < 0){
                    if (temp.right == null){
                        temp.right = new Entry(key, value, null, null, temp);
                        entries.add(temp.right);
                        break;
                    }
                    temp = temp.right;
                } else if (comparator.compare(temp.key, key) > 0){
                    if (temp.left == null){
                        temp.left = new Entry(key, value, null, null, temp);
                        entries.add(temp.left);
                        break;
                    }
                    temp = temp.left;
                } else {
                    Object old = temp.value;
                    temp.value = value;
                    return old;
                }
            }
        }
        size++;
        return value;
    }

    @Override
    public Object remove(Object key) {
        Entry temp = this.root;
        while(temp != null) {
            if(comparator.compare(temp.key, key) < 0) {
                temp = temp.right;
            } else if (comparator.compare(temp.key, key) > 0) {
                temp = temp.left;
            } else {
                    Object old = temp.value;
                        temp.key = temp.right.key;
                        temp.value = temp.right.value;
                        temp.right = temp.right.right;
                    return old;
            }
        }
        return null;
    }

    @Override
    public Object get(Object key) {
        Entry temp = this.root;
        while (temp != null){
            if (comparator.compare(temp.key, key) < 0){
                temp = temp.right;
            } else if (comparator.compare(temp.key, key) > 0){
                temp = temp.left;
            } else {
                return temp.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        Entry temp = this.root;
        while (temp != null){
            if (comparator.compare(temp.key, key) < 0){
                temp = temp.right;
            } else if (comparator.compare(temp.key, key) > 0){
                temp = temp.left;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry entry : entries) {
            if (entry.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] keys() {
        Object[] keys = new Object[size];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = entries.get(i).getKey();
        }
        return keys;
    }

    @Override
    public Object[] values() {
        Object[] values = new Object[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = entries.get(i).getValue();
        }
        return values;
    }

    @Override
    public Entry[] entries() {
        Entry[] all = new Entry[size];
        for (int i = 0; i < size; i++) {
            all[i] = new Entry(entries.get(i).getKey(), entries.get(i).getValue());
        }
        return all;
    }

    @Override
    public String toString() {
        return "TreeMap{" +
                "root=" + root +
                '}';
    }

    private static class Entry implements Map.Entry {
        Object key;
        Object value;
        Entry left;
        Entry right;
        Entry parent;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Entry(Object key, Object value, Entry left, Entry right, Entry parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
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
            Object value1 = this.value;
            this.value = value;
            return value1;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

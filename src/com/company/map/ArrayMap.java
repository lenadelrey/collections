package com.company.map;

import java.util.Arrays;

public class ArrayMap implements Map {
    private Object[] keys;
    private Object[] values;
    private int size = 0;

    public ArrayMap() {
        this.keys = new Object[10];
        this.values = new Object[10];
    }

    public static void main(String[] args) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(1, "Hello 1");
        arrayMap.put(2, "Hello 2");
        arrayMap.put(3, "Hello 3");
        arrayMap.put(4, "Hello 4");
        arrayMap.put(5, "Hello 5");
        arrayMap.put(3, "Hello 33");
        System.out.println(arrayMap);

        arrayMap.remove(3);
        System.out.println(arrayMap);
        System.out.println(Arrays.toString(arrayMap.keys()));
        arrayMap.put(3, "Zdarova");
        System.out.println(arrayMap);
        System.out.println(Arrays.toString(arrayMap.entries()));

    }

    private void resize() {
        int newSize = size + (size / 2);
        Object[] newKeys = new Object[newSize];
        Object[] newValues = new Object[newSize];
        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        this.keys = newKeys;
        this.values = newValues;
    }

    @Override
    public Object put(Object key, Object value) {
        for (int i = 0; i < size; i++) {
            Object old = values[i];
            if (keys[i] == key) {
                values[i] = value;
                return old;
            }
        }
        keys[size] = key;
        values[size++] = value;
        return value;
    }

    @Override
    public Object remove(Object key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                Object old = values[i];
                for (int j = i; j < size; j++) {
                    values[j] = values[j + 1];
                    keys[j] = keys[j + 1];
                }
                size--;
                return old;
            }
        }
        return null;
    }

    @Override
    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] keys() {
        Object[] all = new Object[keys.length];
        for (int i = 0; i < all.length; i++) {
            all[i] = keys[i];
        }
        return all;
    }

    @Override
    public Object[] values() {
        Object[] all = new Object[values.length];
        for (int i = 0; i < all.length; i++) {
            all[i] = values[i];
        }
        return all;
    }

    @Override
    public Entry[] entries() {
        Entry[] array = new Entry[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Entry(keys[i], values[i]);
        }
        return array;
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
        return "ArrayMap{" +
                "keys=" + Arrays.toString(keys) +
                ", values=" + Arrays.toString(values) +
                ", size=" + size +
                '}';
    }
}

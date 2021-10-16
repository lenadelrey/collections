package com.company.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashMap<K, V> implements Map<K, V> {
    private Node[] table = new Node[16];
    private int size;
    private List<Entry> cache = new ArrayList<>();


    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Hello 1", 1);
        hashMap.put("Hello 2", 2);
        hashMap.put("Hello 3", 3);
        hashMap.put("Hello 4", 4);
        hashMap.put("Hello 111", 111);
        hashMap.put("Hello 5", 5);
        hashMap.put("Hello 6", 5);
        hashMap.put("Hello 7", 5);
        hashMap.put("Hello 8", 5);
        hashMap.put("Hello 9", 5);
        hashMap.put("Hello 10", 5);
        hashMap.put("Hello 11", 5);
        hashMap.put("Hello 12", 5);
        hashMap.put("Hello 13", 5);
        hashMap.put("Hello 14", 5);
        hashMap.put("Hello 15", 5);
        hashMap.put("Hello 16", 5);
        hashMap.put("Hello 17", 5);
        hashMap.put("Hello 18", 5);
        hashMap.put("Hello 19", 5);
        hashMap.put("Hello 20", 5);
        hashMap.put("Hello 21", 5);

        System.out.println(hashMap);

    }

    private void resize(){
        int newSize = table.length + (table.length / 2);
        Node[] newArray = new Node[newSize];
        Node[] table = this.table;
        this.table = newArray;

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Node temp = table[i];
                Node next = table[i].next;
                int index = getIndex(temp.getKey());
                while(temp != null) {
                    if (next!=null && getIndex(next.getKey()) != index) {
                        if (this.table[getIndex(next.getKey())] == null) {
                            this.table[getIndex(next.getKey())] = next;
                        } else {
                            Node temp2 = this.table[getIndex(next.getKey())];
                            while (temp2 != null){
                                if (temp2.next == null) {
                                    temp2.next = next;
                                    break;
                                }
                                temp2 = temp2.next;
                            }
                        }
                        temp.next = null;
                    }
                    this.table[getIndex(temp.getKey())] = temp;
                    temp = temp.next;
                }
            }
        }
    }

    private int getIndex(Object key){
        int i = key.hashCode();
        return Math.abs(i % table.length);
    }

    @Override
    public Object put(Object key, Object value) {
        if(size == 0.75 * table.length) {
            resize();
        }
        int index = getIndex(key);
        Node node = new Node(key, value);
        if (table[index] == null) {
            table[index] = node;
            cache.add(node);
        } else {
            Node temp = table[index];
            while(temp.next != null) {
                if (temp.next.key.equals(key)){
                    Object old = temp.next.getValue();
                    temp.next.setValue(value);
                    return old;
                }
                temp = temp.next;
            }
            temp.next = node;
            cache.add(node);
        }
        size++;
        return value;
    }

    @Override
    public Object remove(Object key) {
        int index = getIndex(key);
        Object old = null;
        Node temp = table[index];
        if (temp.next == null) {
            old = table[index];
            table[index] = null;
            cache.remove(old);
            return old;
        }
        while(temp.next != null) {
            if(temp.next.key.equals(key)) {
                Node left = temp;
                Node remove = temp.next;
                old = remove.value;
                Node right = temp.next.next;
                left.next = right;
                remove.key = remove.value = null;
                cache.remove(remove);
            }
            temp = temp.next;
        }
        return old;
    }

    @Override
    public Object get(Object key) {
        Node node = table[getIndex(key)];
        while(node.next != null) {
            if(node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Entry entry : cache) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry entry : cache) {
            if (entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] keys() {
        Object[] keys = new Object[size];
        for (int i = 0; i < size; i++) {
            keys[i] = cache.get(i).getKey();
        }
        return keys;
    }

    @Override
    public Object[] values() {
        Object[] values = new Object[size];
        for (int i = 0; i < size; i++) {
            values[i] = cache.get(i).getValue();
        }
        return values;
    }

    @Override
    public Entry[] entries() {
        return cache.toArray(new Entry[0]);
    }

    private static class Node implements Map.Entry{
        private Object key;
        private Object value;
        private Node next;

        Node(Object key, Object value) {
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
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                ", l=" + table.length +
                '}';
    }
}

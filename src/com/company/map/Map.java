package com.company.map;

public interface Map<K, V> {
    V put(K key, V value);

    Object remove(Object key);

    Object get(Object key);

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    Object[] keys();

    Object[] values();

    Entry[] entries();

    interface Entry {
        Object getKey();

        Object getValue();

        Object setValue(Object value);
    }
}

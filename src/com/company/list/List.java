package com.company.list;

public interface List<T> extends Iterable<T>{
    void add(T o);

    T get(int index);

    T delete(int index);

    T set(int index, T o);

    void add(int index, T o);

    boolean contains(T o);

    int size();

    boolean isEmpty();

    Object[] toArray();

}

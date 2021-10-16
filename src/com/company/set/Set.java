package com.company.set;

public interface Set {
    void add(Object ob);

    Object remove(Object ob);

    Object[] toArray();

    boolean contains(Object ob);

    int size();

    boolean isEmpty();

    Object first();

    Object last();
}

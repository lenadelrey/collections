package com.company.stack;

public interface Stack extends Iterable{
    Object push(Object o);

    Object pop();

    Object peek();

    boolean empty();

    int search(Object o);
}

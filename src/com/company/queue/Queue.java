package com.company.queue;


public interface Queue<T> extends Iterable<T> {
    boolean add(T o);//exception

    boolean offer(T o);

    T remove();//exception

    T poll();

    T element();//exception

    T peek();

    boolean empty();

    int size();
}

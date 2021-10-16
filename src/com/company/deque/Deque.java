package com.company.deque;

import com.company.queue.Queue;
import com.company.stack.Stack;

public interface Deque extends Queue, Stack {
    boolean addFirst(Object o);//exception

    boolean addLast(Object o);//exception

    boolean offerFirst(Object o);

    boolean offerLast(Object o);

    Object removeFirst();//exception

    Object removeLast();//exception

    Object pollFirst();

    Object pollLast();

    Object elementFirst();//exception

    Object elementLast();//exception

    Object peekFirst();

    Object peekLast();
}

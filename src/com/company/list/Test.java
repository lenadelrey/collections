package com.company.list;

import java.util.List;

public class Test<T> {
    T type;

    public T test(List<?> t){
        System.out.println(t);
        return null;
    }

//    public static <E> E text(E element){
//
//    }

    public static void main(String[] args) {
        Test<Integer> text = new Test<>();
        Test<String> text2 = new Test<>();

    }
}

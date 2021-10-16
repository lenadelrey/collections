package com.company;

public class User implements Comparable<User>{
    private int age;
    private String name;

    @Override
    public int compareTo(User o) {
        return 0;
    }
}

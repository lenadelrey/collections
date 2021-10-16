package com.company;

import java.util.Arrays;

public class Test {

    public static boolean binarySearch(int[] a, int value) {
        int first = 0;
        int last = a.length;
        while (first <= last) {
            int current = (last + first) / 2;
            if(a[current] < value){
                 first = current + 1;
            } else if(a[current] > value) {
                last = current - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void sort(int[] a) {
        for (int j = 0; j < a.length; j++) {
            for (int i = j; i < a.length - 1; i++) {
                if (a[j] > a[i + 1]) {
                    int b = a[j];
                    a[j] = a[i + 1];
                    a[i + 1] = b;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] ints = {5, 35, 47, 52, 73, 81, 9, 37, 63, 54, 3, 1};
        Test.sort(ints);
        System.out.println(Test.binarySearch(ints, 73));
        System.out.println(Arrays.toString(ints));


//        List<String> a = new ArrayList<>();
//        a.add("Hello 1");
//        a.add("Hello 2");
//        a.add(null);
//        a.add("Hello 4");
//        System.out.println(a);

//        List<String> b = new LinkedList<>();
//        b.add("Hello 1");
//        b.add("Hello 2");
//        b.add("Hello 3");
//        b.add("Hello 4");
//        b.add("Hello 5");
//        System.out.println(b);

//        Set<String> c = new HashSet<>();
//        c.add("Hello 1");
//        c.add("Hello 2");
//        c.add("Hello 1");
//        c.add("Hello 4");
//        c.add("Hello 5");
//        System.out.println(c);
//
//        Set<String> d = new TreeSet<>();
//        d.add("Hello 1");
//        d.add("Hello 2");
//        d.add("Hello 1");
//        d.add("Hello 4");
//        d.add("Hello 5");
//        System.out.println(d);

//        Set<String> e = new HashSet<>();
//        e.add("Hello 1");
//        e.add("Hello 2");
//        e.add(null);
//        e.add("Hello 1");
//        e.add(null);
//        System.out.println(e);

//        Map<String, String> n = new TreeMap<>();
//        n.put("sd", null);
//        n.put("Hello 2", "Hello 2");
//        n.put(":sd", "Hello 3");
//        System.out.println(n);

//        List<String> a = new ArrayList<>();
//        for (int i = 0; i < 100000; i++) {
//            a.add("Hello " + i);
//        }

//        long start = System.nanoTime();
//        a.add(50000, "Hi");
//        long end = System.nanoTime();
//        System.out.println(end - start);
    }
}

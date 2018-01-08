package com.zoom;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        Iterator<String> i = list.iterator();
        while (i.hasNext()) System.out.println(i.next());

        list.forEach(System.out::println);
    }
}

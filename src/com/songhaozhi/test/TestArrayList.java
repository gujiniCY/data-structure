package com.songhaozhi.test;

import com.songhaozhi.list.ArrayList;

public class TestArrayList {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        System.out.println(list.isEmpty());
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        System.out.println(list);
        list.set(0, 10001);
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.indexOf(33));
        System.out.println(list.contains(1515));
        list.add(list.size()-1,100);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);

    }
}

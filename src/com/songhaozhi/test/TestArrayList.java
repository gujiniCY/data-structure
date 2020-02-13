package com.songhaozhi.test;

import com.songhaozhi.list.ArrayList;

public class TestArrayList {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}

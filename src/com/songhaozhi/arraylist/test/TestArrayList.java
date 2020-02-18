package com.songhaozhi.arraylist.test;

import com.songhaozhi.arraylist.ArrayList;

public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("12");
        list.add("true");
        list.add("wer");
        list.add("4543");
        list.add("啊实打实");
        System.out.println(list);

        list.add(1,"asdasd");
        System.out.println(list);

        list.remove(4);
        System.out.println(list);
    }
}

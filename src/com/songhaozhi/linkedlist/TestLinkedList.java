package com.songhaozhi.linkedlist;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("12");
        list.add("true");
        list.add("wer");
        list.add("4543");
        list.add("啊实打实");
        System.out.println(list);

        list.add(1,"asdasd");
        System.out.println(list);

        list.set(2, "false");
        System.out.println(list);
        list.remove(4);
        System.out.println(list);
        System.out.println(list.indexOf("asdasd"));
    }
}

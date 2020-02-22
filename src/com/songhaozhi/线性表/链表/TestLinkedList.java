package com.songhaozhi.线性表.链表;

import com.songhaozhi.线性表.动态数组.List;
import com.songhaozhi.线性表.链表.circle.CircleLinkedList;

public class TestLinkedList {

    public static void main(String[] args) {
        List<String> list = new CircleLinkedList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        System.out.println(list);
        list.add(0,"55");
        System.out.println(list);
        list.add(list.size(),"66");
        System.out.println(list);
        list.set(2, "false");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.indexOf("11"));
    }
}

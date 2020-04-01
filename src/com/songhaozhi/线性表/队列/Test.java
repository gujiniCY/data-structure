package com.songhaozhi.线性表.队列;

public class Test {

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.enQueueFront(11);
        deque.enQueueFront(22);
        deque.enQueueRear(33);
        deque.enQueueRear(44);
        System.out.println(deque.front());
        System.out.println(deque.rear());
        while (!deque.isEmpty()){
            System.out.println(deque.deQueueRear());
        }
    }
}

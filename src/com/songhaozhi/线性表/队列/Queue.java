package com.songhaozhi.线性表.队列;

import com.songhaozhi.线性表.动态数组.List;
import com.songhaozhi.线性表.链表.LinkedList;

/**
 * @author songhaozhi
 */
public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * 入队
     *
     * @param element
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 出队
     *
     * @return
     */
    public E deQueue() {
        return list.remove(0);
    }

    /**
     * 获取头元素
     *
     * @return
     */
    public E front() {
        return list.get(0);
    }

}

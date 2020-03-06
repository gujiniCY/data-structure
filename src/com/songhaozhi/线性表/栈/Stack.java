package com.songhaozhi.线性表.栈;

import com.songhaozhi.线性表.动态数组.ArrayList;
import com.songhaozhi.线性表.动态数组.List;

public class Stack<E> {

    private List<E> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * 入栈：往数组的最后一位添加元素
     *
     * @param element
     */
    public void push(E element) {
        list.add(element);
    }

    /**
     * 出栈：删除数组最后一个元素
     *
     * @return
     */
    public E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取队头元素
     *
     * @return
     */
    public E top() {
        return list.get(list.size() - 1);
    }
}

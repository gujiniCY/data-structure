package com.songhaozhi.linkedlist;

import com.songhaozhi.arraylist.List;

/**
 * 公共代码
 *
 * @author songhaozhi
 */
public abstract class AbstractList<E> implements List<E> {

    /**
     * 元素数量
     */
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E e) {
        add(size, e);
    }
    /**
     * 检查index的范围
     *
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 根据范围添加检测的范围
     *
     * @param index
     */
    protected void rangeCheckForAdd(int index) {
        /**
         * 假设size=5;当index也等于5的时候是允许添加的，相当于往最后面一位添加
         */
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 返回一个异常详细信息
     *
     * @param index
     * @return
     */
    protected String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }
}

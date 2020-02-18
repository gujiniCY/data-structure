package com.songhaozhi.arraylist;

/**
 * @author songhaozhi
 */
public interface List<E> {

    /**
     * -1
     */
    int ELEMENT_NOT_FOUND = -1;

    /**
     * 返回列表中元素的个数
     */
    int size();

    /**
     * 如果此列表不包含元素，则返回true。
     */
    boolean isEmpty();

    /**
     * 该列表是否包含指定的元素
     *
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 添加元素
     *
     * @param e
     * @return
     */
    void add(E e);

    /**
     * 插入元素到指定的下标位置
     *
     * @param index
     * @param e
     */
    void add(int index, E e);

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param e
     * @return 原来的元素
     */
    E set(int index, E e);


    /**
     * 通过下标删除元素
     *
     * @param index
     * @return 原来的元素
     */
    E remove(int index);

    /**
     * 清空列表元素
     */
    void clear();

    /**
     * 获取指定下标的元素
     *
     * @param index 下标
     * @return
     */
    E get(int index);

    /**
     * 返回指定元素第一次出现的下标
     *
     * @param e
     * @return
     */
    int indexOf(E e);
}

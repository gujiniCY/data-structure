package com.songhaozhi.list;

public interface List<T> {

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
     * @param element
     * @return
     */
    boolean contains(int element);

    /**
     * 添加元素
     *
     * @param t
     * @return
     */
    void add(T t);

    /**
     * 插入元素到指定的下标位置
     *
     * @param index
     * @param t
     */
    void add(int index, T t);

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param t
     * @return 原来的元素
     */
    T set(int index, T t);


    /**
     * 通过下标删除元素
     *
     * @param index
     * @return 原来的元素
     */
    int remove(int index);

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
    T get(int index);

    /**
     * 返回指定元素第一次出现的下标
     *
     * @param element
     * @return
     */
    int indexOf(int element);
}

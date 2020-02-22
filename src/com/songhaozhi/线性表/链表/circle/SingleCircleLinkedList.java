package com.songhaozhi.线性表.链表.circle;

import com.songhaozhi.线性表.链表.AbstractList;

/**
 * 单向循环链表
 * add();
 * remove();
 * if (index == 0) {
 * }
 *
 * @author songhaozhi
 */
public class SingleCircleLinkedList<E> extends AbstractList<E> {
    /**
     * 指向链表的第一个元素
     */
    private Node<E> first;

    /**
     *
     */
    @Override
    public void add(int index, E e) {
        rangeCheckForAdd(index);
        if (index == 0) {
            //先不要改first，因为first一旦修改了那么node();去找最后一个节点的时候node()用到了first
            Node<E> newFirst = new Node<>(e, first);
            //获取最后一个节点
            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            last.next = newFirst;
            first = newFirst;
        } else {
            //获取上一个节点
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(e, prev.next);
        }
        size++;
    }

    @Override
    public E set(int index, E e) {
        //取出原来的node
        Node<E> node = node(index);
        //取出原来存储的元素
        E old = node.element;
        //将新元素放入element
        node.element = e;
        return old;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            if (size == 1) {
                first = null;
            } else {
                //改变first之前先获取最后一个节点
                Node<E> last = (size == 0) ? first : node(size - 1);
                first = first.next;
                last.next = first;
            }
        } else {
            //获取前面的元素
            Node<E> prev = node(index - 1);
            //当前删除的元素
            node = prev.next;
            //把需要删除的元素的next赋给prev的next
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        /**
         * 最好:O(1)
         * 最坏:O(n)
         * 平均:O(n)
         */
        return node(index).element;
    }

    @Override
    public int indexOf(E e) {
        Node<E> node = first;
        if (e == null) {
            //遍历所有元素
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                //重新把下一个元素赋值给node
                node = node.next;
            }
        } else {
            //遍历所有元素
            for (int i = 0; i < size; i++) {
                if (e.equals(node.element)) {
                    return i;
                }
                //重新把下一个元素赋值给node
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点对象
     *
     * @param index 索引
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {
        /**
         * 存储的元素
         */
        E element;
        /**
         * 指向下一个Node
         */
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 重写toString();
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("LinkedList{size=").append(size).append(",[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node.element);

            node = node.next;
        }
        string.append("]}");
        return string.toString();
    }
}

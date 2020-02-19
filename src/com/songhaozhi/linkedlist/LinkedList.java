package com.songhaozhi.linkedlist;

/**
 * 链表
 *
 * @author songhaozhi
 */
public class LinkedList<E> extends AbstractList<E> {
    /**
     * 指向链表的第一个元素
     */
    private Node<E> first;

    /**
     * 当index等于0的时候
     * <p>
     * 创建的新节点的next为first，也就是之前的第一个元素
     * new Node<>(e,first);
     * <p>
     * 现在的first为新建的元素
     * first = new Node<>(e,first);
     * <p>
     * <br>
     * 获取到上一个节点以后，开始创建需要添加的节点
     * <p>
     * 第一个参数为需要添加的元素，第二个参数为后一个节点的引用，
     * 当前的prev.next指向的就是后一个元素的引用
     * new Node<E>(e,prev.next);
     * <p>
     * 把上一个节点的next指向创建好的新元素
     * prev.next = new Node<E>(e,prev.next);
     * <p>
     */
    @Override
    public void add(int index, E e) {
        rangeCheckForAdd(index);
        if (index == 0) {
            first = new Node<>(e, first);
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
    /**
     * 删除第一个元素的时候
     * first.next为第二个元素的引用，所以直接first = 第二个元素的引用就可以了
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
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

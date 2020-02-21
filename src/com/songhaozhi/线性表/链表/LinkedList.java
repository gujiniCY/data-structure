package com.songhaozhi.线性表.链表;

/**
 * 双向链表
 *
 * @author songhaozhi
 */
public class LinkedList<E> extends AbstractList<E> {
    /**
     * 指向链表的第一个节点
     */
    private Node<E> first;
    /**
     * 指向最后一个节点
     */
    private Node<E> last;

    /**
     * 添加节点
     * 图见 - 双向链表的图片.jpg
     *
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {
        rangeCheckForAdd(index);
        //往最后面添加节点
        if (index == size) {
            //之前的最后一个节点
            Node<E> oldLast = last;
            //新建节点并赋值给last
            last = new Node<>(oldLast, e, null);
            //oldLast为null表示是添加的第一个节点
            if (oldLast == null) {
                first = last;
            } else {
                //之前的最后一个节点的下一个为新的节点last
                //也可以通过last.prev获取原本的最后一个节点
                oldLast.next = last;
            }
        } else {
            //新添加节点的下一个
            Node<E> next = node(index);
            //新添加节点的上一个
            Node<E> prev = next.prev;
            //新节点的线连接
            Node<E> node = new Node<>(prev, e, next);
            //下一个元素的上一个节点为新节点
            next.prev = node;
            //index为0的时候
            if (prev == null) {
                first = node;
            } else {
                //上一个元素的下一个节点为新节点
                prev.next = node;
            }
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
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        //index==0
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }
        //index == size - 1
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
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
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    private static class Node<E> {
        /**
         * 指向上一个Node
         */
        Node<E> prev;
        /**
         * 存储的元素
         */
        E element;
        /**
         * 指向下一个Node
         */
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
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

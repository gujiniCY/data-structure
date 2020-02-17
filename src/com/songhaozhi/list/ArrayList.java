package com.songhaozhi.list;

/**
 * 创建一个可以增删改查int类型值的ArrayList
 *
 * @author songhaozhi
 */
public class ArrayList<E> implements List<E> {
    /**
     * 该ArrayList包含的元素数量
     */
    private int size = 0;
    /**
     * 存放元素的数组
     */
    transient Object[] elementData;
    /**
     * 默认数组创建容量
     */
    public static final int DEFAULT_CAPACITY = 10;
    /**
     * -1
     */
    public static final int ELEMENT_NOT_FOUND = -1;


    /**
     * 可传定制初始容量的构造方法
     *
     * @param capacity
     */
    public ArrayList(int capacity) {
        //当capacity小于DEFAULT_CAPACITY的时候使用初始值
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.elementData = new Object[capacity];
    }

    /**
     * 默认构造方法
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

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
    public void add(E element) {
        add(size, element);
    }

    /**
     * 例子:假设元素为11,22,33,44,55
     * 如果传来的index为2,我们就需要把33,44,55向后挪动一位，也就是index到size-1的范围
     * <p>
     * 删除操作是通过下标将元素一个个往前面挪动，而添加则是最后开始一个个往后挪动。
     * 因为11,22,33,44,55加入33往后挪动则会覆盖掉44，再往后挪动依然是33覆盖55,所以需要反着来
     * <p>
     * for (int i = size - 1; i >= index; i--) {
     * elementData[i + 1] = elementData[i];
     * }
     * <p>
     * 第1遍循环 i = (5-1) = 4;index=2;
     * elementData[5] = elementData[4];
     * 第2遍循环 i = 3;index=2;
     * elementData[4] = elementData[3];
     * 第3遍循环 i = 2;index=2;
     * elementData[3] = elementData[2];
     *
     * 后期修改了条件，具体看https://github.com/gujiniCY/data-structure/commit/ed8e955185fcb0bb8ad6188c3f26e671dc41fbae
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        //如果容量不够，则扩容
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = element;
        size++;
    }

    /**
     * 保证要有capacity的容量
     *
     * @param capacity 至少需要的容量
     */
    private void ensureCapacity(int capacity) {
        //旧容量为目前数据的长度
        int oldCapacity = elementData.length;
        //如果旧容量大于等于至少需要的容量则不需要扩容
        if (oldCapacity >= capacity) {
            return;
        }
        //新的容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //创建一个新的数组
        E[] newElementData = (E[]) new Object[newCapacity];
        //将旧数组中的所有元素移动到新数组中
        for (int i = 0; i < size; i++) {
            newElementData[i] = elementData(i);
        }
        //将elementData指向newelementData;
        elementData = newElementData;
        System.out.println("旧容量为" + oldCapacity + "扩容以后" + newCapacity);
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        //取出原来的元素
        E old = elementData(index);
        //通过下标设置新值
        elementData[index] = element;
        return old;
    }

    /**
     * 删除操作是挪动所需要删除元素的下标后一位到数组的最后一位
     * <p>
     * 例子:假设元素为11,22,33,44,55
     * 如果传来的index为2,则需要删除元素为33,所以需要把44,55向前一位挪动
     * 所以挪动的下标就是3和4，也就是 index + 1 到 size - 1
     *
     * 后期修改了条件，具体看https://github.com/gujiniCY/data-structure/commit/ed8e955185fcb0bb8ad6188c3f26e671dc41fbae
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        //取出原来的元素
        E old = elementData(index);
        for (int i = index + 1; i < size; i++) {
            elementData[i - 1] = elementData[i];
        }
        //移动以后size--
        size--;
        //清除掉数组里面的最后一个元素
        elementData[size] = null;
        /**
         * 可以合并为一句，先减size然后清空最后一个元素
         * elementData[--size] = null;
         */
        return old;
    }

    @Override
    public void clear() {
        /**
         * 因为是泛型，如果是对象
         * elementData数组中保留的是对象的地址，
         * 所以clear()方法需要把对象的引用指向null，
         * 避免浪费内存
         */
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    @Override
    public int indexOf(E element) {
        //如果element为null则返回第一个null元素的位置
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            //遍历数组，如果当前下标的元素等于element则返回下标i
            for (int i = 0; i < size; i++) {
                if (element.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 检查index的范围
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 根据范围添加检测的范围
     *
     * @param index
     */
    private void rangeCheckForAdd(int index) {
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
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }

    /**
     * 重写toString();
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("ArrayList{size=").append(size).append(",elementData=[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elementData[i]);
        }
        string.append("]}");
        return string.toString();
    }
}

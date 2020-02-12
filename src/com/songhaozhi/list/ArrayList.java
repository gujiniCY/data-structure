package com.songhaozhi.list;

/**
 * 创建一个可以增删改查int类型值的ArrayList
 */
public class ArrayList implements List<Integer> {
    /**
     * 该ArrayList包含的元素数量
     */
    private int size = 0;
    /**
     * 存放元素的数组
     */
    private int[] elementData;
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
        this.elementData = new int[capacity];
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
    public boolean contains(int element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(Integer element) {
        add(size, element);
    }

    /**
     * 例子:假设元素为11,22,33,44,55
     * 如果传来的index为2,我们就需要把33,44,55向后挪动一位，也就是index到size-1的范围
     *
     * 删除操作是通过下标将元素一个个往前面挪动，而添加则是最后开始一个个往后挪动。
     * 因为11,22,33,44,55加入33往后挪动则会覆盖掉44，再往后挪动依然是33覆盖55,所以需要反着来
     *
     * for (int i = size - 1; i >= index; i--) {
     *      elementData[i + 1] = elementData[i];
     * }
     *
     * 第1遍循环 i = (5-1) = 4;index=2;
     * elementData[5] = elementData[4];
     * 第2遍循环 i = 3;index=2;
     * elementData[4] = elementData[3];
     * 第3遍循环 i = 2;index=2;
     * elementData[3] = elementData[2];
     */
    @Override
    public void add(int index, Integer element) {
        rangeCheckForAdd(index);
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
    }

    @Override
    public Integer set(int index, Integer element) {
        rangeCheck(index);
        //取出原来的元素
        int old = elementData[index];
        //通过下标设置新值
        elementData[index] = element;
        return old;
    }

    /**
     * 删除操作是挪动所需要删除元素的下标后一位到数组的最后一位
     *
     * 例子:假设元素为11,22,33,44,55
     * 如果传来的index为2,则需要删除元素为33,所以需要把44,55向前一位挪动
     * 所以挪动的下标就是3和4，也就是 index + 1 到 size - 1
     */
    @Override
    public int remove(int index) {
        rangeCheck(index);
        //取出原来的元素
        int old = elementData[index];
        for (int i = index + 1; i <= size - 1; i++) {
            elementData[i - 1] = elementData[i];
        }
        //移动以后size--
        size--;
        return old;
    }

    @Override
    public void clear() {
        //只要把size设置为0以后，用户访问不到就可以了，不需要重新创建数组
        size = 0;
    }

    @Override
    public Integer get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public int indexOf(int element) {
        //遍历数组，如果当前下标的元素等于element则返回下标i
        for (int i = 0; i < size; i++) {
            if (elementData[i] == element) {
                return i;
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

package _05_Arrays._5_10_Amortized_Time_Complexity;

/**
 * 自己封装数组类
 * ① 数组状态的判断（容量、个数、是否为空）
 * ② 添加元素
 * ③ 查询、修改元素
 * ④ 查询元素、删除元素
 * ⑤ 泛型【注意释放 loitering objects --- 非必须】
 * ⑥ 动态数组：add时触发扩容；remove触发缩容
 *
 * ⑦ 防止复杂度震荡 --- 懒操作，数据只有容量1/4才缩容，且保障边界条件size为1
 *
 * @author lujinpeng
 * @date 2023-08-31 7:17 下午
 */
public class Array<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    // 数组中有效元素个数；同时也是数组中第一个没有元素的索引
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    /******************************************************************************/
    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    /******************************************************************************/
    public void addLast(E e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//
//        data[size] = e;
//        size++;

        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0, e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e) {

//        // 是否有足够空间添加元素
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }

        // index入参校验
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        // 扩容
        if (size == data.length) {
//            // Java的ArrayList为1.5倍
//            resize(data.length + (data.length >> 1));
            resize(data.length << 1);
        }

        // 元素后移
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // 添加元素
        data[index] = e;
        size++;

    }

    /******************************************************************************/
    // 获取index索引位置的元素
    public E get(int index) {
        // 封装的意义：可以对入参进行有效性校验【无法获取未使用空间，保障数据安全】
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /******************************************************************************/
    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /******************************************************************************/
    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        // 用于JVM回收 loitering objects
        data[size] = null;

        // 触发缩容【防止复杂度震荡。数据只有容量1/4才缩容，且保障边界条件size为1】
        if (data.length >> 1 != 0 && size == data.length >> 2) {
            resize(data.length >> 1);
        }
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }


    /******************************************************************************/
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;

    }

}

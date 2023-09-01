package _05_Arrays._5_5_Query_and_Update_Element;

/**
 * 自己封装数组类
 * ① 数组状态的判断（容量、个数、是否为空）
 * ② 添加元素
 *
 * ③ 查询、修改元素
 *
 * @author lujinpeng
 * @date 2023-08-31 7:17 下午
 */
public class Array {

    private int[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
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
    public void addLast(int e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//
//        data[size] = e;
//        size++;

        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(int e){
        add(0, e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, int e) {

        // 是否有足够空间添加元素
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }

        // index入参校验
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
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
    public int get(int index) {
        // 封装的意义：可以对入参进行有效性校验【无法获取未使用空间，保障数据安全】
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
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

}

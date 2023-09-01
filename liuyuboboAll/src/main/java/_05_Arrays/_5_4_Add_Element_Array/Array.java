package _05_Arrays._5_4_Add_Element_Array;

/**
 * 自己封装数组类：
 * ① 数组状态的判断（容量、个数、是否为空）
 *
 * ② 添加元素
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

}

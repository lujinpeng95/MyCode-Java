package _03_Selection_Sort._3_3_Using_Generics;

import core.util.ArrayUtil;

import java.util.Arrays;

/**
 * 选择排序：每次都找到『未处理元素里』最小的一个元素
 *
 * @author lujinpeng
 * @date 2023-08-29 4:43 下午
 */
public final class SelectionSort {

    private SelectionSort() {

    }

    // Comparable 是接口，但泛型使用上是 extends 关键字
    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 循环不变量：arr[0...i) 是有序的；arr[i...n) 是无序的
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 选择 arr[i...n) 中的最小值
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            ArrayUtil.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

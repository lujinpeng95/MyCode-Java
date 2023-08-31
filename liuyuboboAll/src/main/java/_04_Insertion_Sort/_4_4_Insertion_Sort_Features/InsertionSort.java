package _04_Insertion_Sort._4_4_Insertion_Sort_Features;

import core.util.ArrayGenerator;
import core.util.ArrayUtil;
import core.util.SortingHelper;

import java.util.Arrays;

/**
 * 插入排序：扑克牌排序方式。每次处理一个数，插入到前面排好序的数列中
 * 【对比选择排序】选择排序-前面排好序的数，是整个数列中最小的
 *
 * 插入排序特性：当数组近乎有序，时间复杂度为 O(n)
 *
 * @author lujinpeng
 * @date 2023-08-31 2:07 下午
 */
public final class InsertionSort {

    private InsertionSort() {}

    // 常数级别优化：交换操作优化为平移操作
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E tmp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                // 交换操作优化为平移操作
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {

            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(InsertionSort.class, "sort", arr);
        }
    }

}

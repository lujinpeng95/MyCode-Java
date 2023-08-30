package _03_Selection_Sort._3_5_Performance_of_Selection_Sort;

import core.util.ArrayGenerator;
import core.util.ArrayUtil;
import core.util.SortingHelper;

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

//        int n = 10_000;
//        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

//        long tic = System.currentTimeMillis();
//        SelectionSort.sort(arr);
//        long toc = System.currentTimeMillis();
//
//        // 秒
//        double time = (toc - tic) / 1000.0f;
//
//        // 由于数量比较大，无法通过直接 print 观察是否排序，需要借助程序验证
//        if (!SortingHelper.isSorted(arr)) {
//            throw new RuntimeException("SelectionSort failed");
//        }
//        System.out.println(" 耗时：" + time + " 秒" );

//        SortingHelper.sortTest(SelectionSort.class, arr);

        int[] dataSize = {10_000, 100_000};
        for (int n2 : dataSize) {
            Integer[] arr2 = ArrayGenerator.generateRandomArray(n2, n2);
            // 10倍的规模，耗时为100倍
            SortingHelper.sortTest(SelectionSort.class, arr2);
        }

    }

}

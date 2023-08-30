package _03_Selection_Sort._3_7_Another_Selection_Sort;

import core.util.ArrayGenerator;
import core.util.ArrayUtil;
import core.util.SortingHelper;

/**
 * 选择排序作业：从后往前扫描
 *
 * @author lujinpeng
 * @date 2023-08-30 10:14 下午
 */
public final class SelectionSort {
    private SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 循环不变量：arr[0...i) 是有序的；arr[i...n) 是无序的
        for (int i = arr.length - 1; i >= 0; i--) {

            // 选择 arr[0...i] 中的最大值
            int maxIdx = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }

            ArrayUtil.swap(arr, i, maxIdx);
        }
    }

    public static void main(String[] args){

        int[] dataSize = {10000, 100000};
        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(SelectionSort.class, arr);
        }
    }
}

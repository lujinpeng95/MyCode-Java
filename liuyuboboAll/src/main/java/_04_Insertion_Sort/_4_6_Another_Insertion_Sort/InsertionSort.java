package _04_Insertion_Sort._4_6_Another_Insertion_Sort;

import core.util.ArrayGenerator;
import core.util.SortingHelper;

/**
 * 插入排序作业：从后往前扫描
 *
 * @author lujinpeng
 * @date 2023-08-31 4:56 下午
 */
public final class InsertionSort {

    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 循环不变量：arr(i...n] 是有序的；arr[0...i) 是无序的
        for (int i = arr.length -1; i >= 0; i--) {
            E tmp = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && tmp.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args){

        int[] dataSize = {10000, 100000};
        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(InsertionSort.class, arr);
        }
    }

}

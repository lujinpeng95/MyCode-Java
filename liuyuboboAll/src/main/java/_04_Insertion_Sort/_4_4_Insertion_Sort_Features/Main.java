package _04_Insertion_Sort._4_4_Insertion_Sort_Features;

import core.util.ArrayGenerator;
import core.util.SortingHelper;

import java.util.Arrays;

/**
 * 选择排序 vs. 插入排序
 * 插入排序特性：当数组近乎有序，时间复杂度为 O(n)
 *
 * @author lujinpeng
 * @date 2023-08-31 4:48 下午
 */
public class Main {

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {

            System.out.println("Random Array : ");
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(InsertionSort.class, "sort", arr);
            SortingHelper.sortTest(SelectionSort.class, "sort", arr2);

            System.out.println();

            System.out.println("Ordered Array : ");
            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(InsertionSort.class, "sort", arr);
            SortingHelper.sortTest(SelectionSort.class, "sort", arr2);

            System.out.println();
        }
    }

}

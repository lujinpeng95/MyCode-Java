package _04_Insertion_Sort._4_2_Insertion_Sort;

import core.util.ArrayGenerator;
import core.util.ArrayUtil;
import core.util.SortingHelper;

/**
 * 插入排序：扑克牌排序方式。每次处理一个数，插入到前面排好序的数列中
 * 【对比选择排序】选择排序-前面排好序的数，是整个数列中最小的
 *
 * @author lujinpeng
 * @date 2023-08-31 2:07 下午
 */
public final class InsertionSort {

    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 循环不变量：arr[0...i) 是有序的；arr[i...n) 是无序的
        for (int i = 0; i < arr.length; i++) {

            // 将 arr[i] 插入到合适的位置
//            for (int j = i; j - 1 >= 0; j--) {
                  // 本身就是循环的条件
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    ArrayUtil.swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }

            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                ArrayUtil.swap(arr, j, j - 1);
            }
        }
    }

    // 自己的写法
    public static <E extends Comparable<E>> void sort01(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[tmp].compareTo(arr[j]) >= 0) {
                    break;
                }
                tmp = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(InsertionSort.class, arr);
        }
    }

}

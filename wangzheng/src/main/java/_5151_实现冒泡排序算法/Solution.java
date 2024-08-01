package _5151_实现冒泡排序算法;

import core.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.codecrush.cn/oj/problem/25
 * 
 * 冒泡排序算法（已优化）
 * 特点：对基本有序的数列，冒泡排序时间复杂度 O(n)。原地稳定算法
 * 
 * @author lujinpeng
 * @date 2024-08-01 14:25
 */
public class Solution {
    public void bubbleSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        // 每趟排序数列，最后一个元素的 index
        for (int j = n - 1; j > 0; j-- ) {
            boolean noSwap = true;

            for (int i = 0; i < j; i++) {
                if (arr[i] <= arr[i + 1]) {
                    continue;
                }

                int tmp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = tmp;
                // 整轮循环没有元素交换，说明整体已经有序
                noSwap = false;
            }

            if (noSwap) {
                break;
            }

        }
        
    }

    public void bubbleSort2(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        // 第几趟冒泡
        for (int j = 0; j < n; j++ ) {
            boolean noSwap = true;

            for (int i = 0; i < n - 1 - j; i++) {
                if (arr[i] <= arr[i + 1]) {
                    continue;
                }

                int tmp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = tmp;
                // 整轮循环没有元素交换，说明整体已经有序
                noSwap = false;
            }

            if (noSwap) {
                break;
            }

        }

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 5, 1, 6);
        System.out.println(ArrayUtil.nestedToString(list));
        
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        Solution solution = new Solution();
        solution.bubbleSort2(arr, arr.length);
        System.out.println(ArrayUtil.nestedToString(arr));
    }
}

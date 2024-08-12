package _5155_实现归并排序;

import core.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.codecrush.cn/oj/problem/29
 *
 * 
 * @author lujinpeng
 * @date 2024-08-05 10:57
 */
public class Solution {
    
    public void mergeSort(int[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start + ((end - start) >> 1);
        mergeSort(arr, start, pivot);
        mergeSort(arr, pivot + 1, end);
        merge(arr, start, end, pivot);
    }

    private void merge(int[] arr, int start, int end, int pivot) {
        int[] res = new int[end - start + 1];

        int p = start;
        int q = pivot + 1;
        int index = 0;
        while (p <= pivot && q <= end) {
            if (arr[p] <= arr[q]) {
                res[index] = arr[p];
                p++;
            } else {
                res[index] = arr[q];
                q++;
            }
            index++;
        }

        int left = p > pivot ? q : p;
        for (int i = index; i < res.length; i++) {
            res[i] = arr[left];
            left++;
        }

        for (int j = 0; j < res.length; j++) {
            arr[start + j] = res[j];
        }
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 5, 1, 6, 0);
//        List<Integer> list = Arrays.asList(2, 1);
        System.out.println(ArrayUtil.nestedToString(list));

        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        Solution solution = new Solution();
        solution.mergeSort(arr, arr.length);
        System.out.println(ArrayUtil.nestedToString(arr));
    }
}

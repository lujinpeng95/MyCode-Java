package _5153_实现选择排序算法;

import core.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.codecrush.cn/oj/problem/27
 * 
 * @author lujinpeng
 * @date 2024-08-01 16:47
 */
public class Solution {

    public void selectSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[minIndex]) {
                    continue;
                }
                minIndex = j;
            }
            
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 5, 1, 6, 0);
//        List<Integer> list = Arrays.asList(2, 1);
        System.out.println(ArrayUtil.nestedToString(list));

        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        Solution solution = new Solution();
        solution.selectSort(arr, arr.length);
        System.out.println(ArrayUtil.nestedToString(arr));
    }
}

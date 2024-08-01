package _5152_实现插入排序算法;

import core.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.codecrush.cn/oj/problem/26
 * 
 * 
 * @author lujinpeng
 * @date 2024-08-01 16:19
 */
public class Solution {
    public void insertSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        
        for (int i = 1; i < n; i++) {
            int curr = arr[i];
            int insertIndex = i;

            for (int j = i - 1; j >= 0; j--) {
                if (curr >= arr[j]) {
                    break;
                }
                insertIndex = j;
                arr[j + 1] = arr[j];
            }
            arr[insertIndex] = curr;
        }

    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 5, 1, 6);
        System.out.println(ArrayUtil.nestedToString(list));

        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        Solution solution = new Solution();
        solution.insertSort(arr, arr.length);
        System.out.println(ArrayUtil.nestedToString(arr));
    }
}

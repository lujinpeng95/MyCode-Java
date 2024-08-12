package _5154_实现快速排序算法;

import java.util.Random;

/**
 * https://www.codecrush.cn/oj/problem/28
 *
 * @author lujinpeng
 * @date 2024-08-05 12:28
 */
public class Solution {
    public void quickSort(int[] arr, int n) {
        
    }
    
    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int pivotIdx = this.partition(arr, start, end);
        quickSort(arr, start, pivotIdx);
        quickSort(arr, pivotIdx + 1, end);
        
    }
    
    private int partition(int[] arr, int start, int end) {
        if (start >= end) {
            return start;
        }
        Random random = new Random();
        int pivotIdx = random.nextInt(end - start + 1) + start;
        return 0;
    }
}

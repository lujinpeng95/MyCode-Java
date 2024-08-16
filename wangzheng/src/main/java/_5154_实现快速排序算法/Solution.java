package _5154_实现快速排序算法;

import java.util.Random;

/**
 * https://www.codecrush.cn/oj/problem/28
 *
 * @author lujinpeng
 * @date 2024-08-05 12:28
 */
public class Solution {
    private static Random random = new Random();

    public void quickSort(int[] arr, int n) {
        this.quickSort(arr, 0, n - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int p = this.partition(arr, start, end);
        this.quickSort(arr, start, p - 1);
        this.quickSort(arr, p + 1, end);
    }
    
    /**
     * 法一：普通快排，遍历过程中将小的数搬到前面。for 循环不变量 （start, lt] < base、(lt, prob) >= base、[prob, end]未处理
     * 思考：和插入排序区别。插入排序也是依次遍历，但是要插入到已排序区间的合适位置，时间复杂度 O(n) * O(n)。
     * 快排只要放前一个区间就好，用子问题将时间复杂度的乘项 缩减至 O(logn)。整体为 O(nlogn)
     *
     * @param arr 待排序的整型数组
     * @param start 排序的起始位置
     * @param end 排序的结束位置
     * @return 基准元素在排序后的数组中的位置
     */
    private int partition(int[] arr, int start, int end) {
        int pivot = random.nextInt(end - start + 1) + start;
        this.swap(arr, start, pivot);
        int base = arr[start];

        // lt 记录的是 已知的最后一个、小于base的数 所在的索引。prob 做数组遍历
        int lt = start;
        for (int prob = lt + 1; prob <= end; prob++) {
            if (arr[prob] >= base) {
                continue;
            }

            // 将小于 base 的数，移到 lt 后一位
            swap(arr, prob, lt + 1);
            lt++;
        }

        // 将基准元素与 (start, lt] 的最后一个元素互换
        swap(arr, start, lt);
        return lt;
    }

    /**
     * 法二：双路快排，前后并行循环找到第一个大于/小于 base 的数，交换位置。for 循环不变量 （start, lt) < base、[lt, gt]未处理、（gt, end] > base
     * 优点：解决大量重复元素的情景，改善递归树平衡度（将等于 base 的数分摊到了树两端）
     *
     * @param arr 待排序的整型数组
     * @param start 排序的起始位置
     * @param end 排序的结束位置
     * @return 基准元素在排序后的数组中的位置
     */
    private int partition2(int[] arr, int start, int end) {
        int pivot = random.nextInt(end - start + 1) + start;
        this.swap(arr, start, pivot);
        int base = arr[start];

        int lt = start + 1;
        int gt = end;
        while (true) {
            // 找到已知的最后一个、小于base的数 的索引（lt 是其后一个索引）
            while (lt <= end && arr[lt] < base) {
                lt++;
            }
            // 找到已知的最前面一个、大于base的数 的索引（gt 是其前一个索引）
            while (gt >= start + 1 && arr[gt] > base) {
                gt--;
            }
            
            if (lt >= gt) {
                break;
            }
            
            this.swap(arr, lt, gt);
            lt++;
            gt--;
        }
        
        this.swap(arr, start, gt);
        return gt;
    }

    /**
     * 法三：三路快排，遍历过程中将小的数搬到前面，大的数挪到后面。for 循环不变量 [start, lt] < base、(lt, prob) = base、[prob, gt)未处理、[gt, end] > base
     * 优点：解决大量重复元素连在一块的情景，重复的元素一次性都放在了正确的位置
     *
     * @param arr 待排序的整型数组
     * @param start 排序的起始位置
     * @param end 排序的结束位置
     * @return 基准元素在排序后的数组中的位置
     */
    private void quickSort3(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = random.nextInt(end - start + 1) + start;
        this.swap(arr, start, pivot);
        int base = arr[start];

        int lt = start;
        int prob = start + 1;
        int gt = end + 1;
        while (prob < gt) {
            if (arr[prob] > base) {
                this.swap(arr, prob, gt - 1);
                gt--;
                continue;
            } else if (arr[prob] < base) {
                this.swap(arr, prob, lt + 1);
                lt++;
            }
            prob++;
        }
        this.swap(arr, start, lt);
        
        this.quickSort(arr, start, lt - 1);
        this.quickSort(arr, gt, end);
    }

    private void swap(int[] arr, int i, int j) {
        if (i < 0 || j < 0 || i > arr.length - 1 || j > arr.length - 1) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
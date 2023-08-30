package dataStructure;

import core.model.ComparableObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 选择排序
 *
 * @author lujinpeng
 * @date 2023-08-25 10:34 上午
 */
public class SelectionSort {

    static void selectionSort(List<ComparableObject> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int minIdx = i ;
            for (int j = i + 1; j < arr.size(); j++) {
                // 找到未排序数列中最小的元素的下标
                minIdx = arr.get(j).compareTo(arr.get(minIdx)) < 0 ? j : minIdx ;
            }

            ComparableObject tmp;
            tmp = arr.get(minIdx);
            arr.set(minIdx,  arr.get(i));
            arr.set(i, tmp);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 1, 7, 2, 5, 3, 6));

        List<ComparableObject> arr = new ArrayList<>();
        for (Integer i : list) {
            arr.add(new ComparableObject(i));
        }
        selectionSort(arr);
        System.out.println(arr);

    }
}

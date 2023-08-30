package core.util;

import java.util.Objects;

/**
 * @author lujinpeng
 * @date 2023-08-29 5:06 下午
 */
public final class ArrayUtil {

    private ArrayUtil() {

    }

    public static void swap(int[] arr, int i, int j) {
        if (Objects.isNull(arr) || arr.length == 0 || i > arr.length - 1 || j > arr.length - 1 ||
                i == j) {
            return;
        }

        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    // hutool提供了类似方法
    public static <E> void swap(E[] arr, int i, int j) {
        if (Objects.isNull(arr) || arr.length == 0 || i > arr.length - 1 || j > arr.length - 1 ||
                i == j) {
            return;
        }

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

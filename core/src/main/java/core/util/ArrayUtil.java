package core.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author lujinpeng
 * @date 2023-08-29 5:06 下午
 */
public final class ArrayUtil {

    private ArrayUtil() {

    }

    public static void swap(int[] arr, int i, int j) {
        if (Objects.isNull(arr) || i < 0 || j < 0 || i > arr.length - 1 || j > arr.length - 1 || i == j) {
            return;
        }

        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    // hutool提供了类似方法
    public static <E> void swap(E[] arr, int i, int j) {
        if (Objects.isNull(arr) || i < 0 || j < 0 || i > arr.length - 1 || j > arr.length - 1 || i == j) {
            return;
        }

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 将任意嵌套的数组或列表转换为字符串
     *
     * @param obj 要转换的对象（数组或列表）
     * @return 对象的字符串表示
     */
    public static String nestedToString(Object obj) {
        if (obj == null) {
            return "null";
        }

        if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        } else if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        } else if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        } else if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        } else if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        } else if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        } else if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        } else if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        } else if (obj instanceof Object[]) {
            return Arrays.deepToString((Object[]) obj);
        } else if (obj instanceof List) {
            return nestedListToString((List<?>) obj);
        } else {
            return obj.toString();
        }
    }


    /**
     * 将嵌套列表转换为字符串
     *
     * @param list 待转换的嵌套列表
     * @return 转换后的字符串
     */
    public static String nestedListToString(List<?> list) {
        String[] elements = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            elements[i] = nestedToString(list.get(i));
        }
        return Arrays.toString(elements);
    }
}

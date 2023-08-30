package core.util;

/**
 * 数组生成器
 *
 * @author lujinpeng
 * @date 2023-08-29 3:53 下午
 */
public final class ArrayGenerator {
    private ArrayGenerator() {

    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = i;
        }

        return arr;
    }
}

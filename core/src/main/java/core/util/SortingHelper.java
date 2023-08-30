package core.util;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * @author lujinpeng
 * @date 2023-08-30 8:43 下午
 */
public final class SortingHelper {

    private SortingHelper() {

    }

    // 后一个数一定大于等于前一个数
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }

        return true;
    }

    // 测量排序算法耗时
    public static <E extends Comparable<E>> void sortTest(Class<?> clazz, E[] arr) {
        Method sortMethod;
        // 秒
        double time = 0;
        try {
            // 反射获取排序方法【纯泛型入参 Java8 无法处理，此处的泛型都是实现了 Comparable 接口】
            sortMethod = clazz.getMethod("sort", Comparable[].class);
            // 破坏封装
            sortMethod.setAccessible(true);
            // 泛型入参需要特殊处理
            Object[] argument = new Object[] {arr};

            // 时间度量
            long tic = System.currentTimeMillis();
            sortMethod.invoke(null, argument);
            long toc = System.currentTimeMillis();
            time = (toc - tic) / 1000.0f;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 由于数量比较大，无法通过直接 print 观察是否排序，需要借助程序验证
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(clazz.getName() + " failed");
        }
        // 使用千位分隔符格式化数字 n 的打印
        System.out.println(String.format("%s , n = %,d : %f s", clazz.getSimpleName(), arr.length, time));

    }

}

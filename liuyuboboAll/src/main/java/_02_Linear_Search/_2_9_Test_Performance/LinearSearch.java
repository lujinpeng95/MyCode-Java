package _02_Linear_Search._2_9_Test_Performance;

import core.util.ArrayGenerator;

// 只是使用类的方法，所以没必要将类定义为『泛型类』
public class LinearSearch {

    private LinearSearch(){}

    /*
     * 按顺序查找到到target数：最简单的顺序查找
     *
     * 注意点：
     * 1. 方法定义为 static
     * 2. 构造函数私有：防止生成对象
     * 3. 泛型方法：【无法传递基础数据类型了】
     * */
    public static <E> int search(E[] data, E target){

        for(int i = 0; i < data.length; i ++) {
            if(data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){

//        int n = 10000;
//        Integer[] data = ArrayGenerator.generateOrderedArray(n);
//
//        long start = System.currentTimeMillis();
//        // 多次策略减小误差
//        for (int k = 0; k < 100; k++)
//            LinearSearch.search(data, n);
//        long time = System.currentTimeMillis() - start;
//        System.out.println("n = " + n + " , 100 runs : " + time + "ms");

        int[] dataSize = {1_000_000, 10_000_000};
        for(int n: dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs : " + time + "s");
        }
    }
}

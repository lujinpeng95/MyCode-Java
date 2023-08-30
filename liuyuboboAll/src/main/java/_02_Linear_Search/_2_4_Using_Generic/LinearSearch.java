package _02_Linear_Search._2_4_Using_Generic;

// 只是使用类的方法，所以没必要将类定义为『泛型类』
public class LinearSearch {

    private LinearSearch(){}

    /*
     * 按顺序查找到到target数：最简单的顺序查找
     *
     * 注意点：
     * 1. 方法定义为 static
     * 2. 构造函数私有：防止生成对象
     *
     * 3. 泛型方法：【无法传递基础数据类型了】
     * */
    public static <E> int search(E[] data, E target){

        for(int i = 0; i < data.length; i ++) {
            // 改为了 equal 方法
            if(data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){

        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 666);
        System.out.println(res2);
    }
}

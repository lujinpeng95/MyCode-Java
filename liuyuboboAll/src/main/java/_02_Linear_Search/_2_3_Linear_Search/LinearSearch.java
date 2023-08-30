package _02_Linear_Search._2_3_Linear_Search;

public class LinearSearch {

    private LinearSearch(){}

    /*
    * 按顺序查找到到target数：最简单的顺序查找
    *
    * 注意点：
    * 1. 方法定义为 static
    * 2. 构造函数私有：防止生成对象
    * */
    public static int search(int[] data, int target){

        for(int i = 0; i < data.length; i ++) {
            if(data[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){

        int[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 666);
        System.out.println(res2);
    }
}
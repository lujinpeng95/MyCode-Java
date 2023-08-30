package _02_Linear_Search._2_3_Linear_Search;

public class Main {

    public static void main(String[] args){

        int[] data = {24, 18, 12, 9, 16, 66, 32, 4};

//        测试 构造方法为private 无法生成对象
//        LinearSearch ls = new LinearSearch();

        // 同一个包中的类可以直接使用，不用显式的 import
        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 666);
        System.out.println(res2);
    }
}
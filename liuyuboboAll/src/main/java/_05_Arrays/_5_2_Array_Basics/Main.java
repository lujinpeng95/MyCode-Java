package _05_Arrays._5_2_Array_Basics;

/**
 * 数组体验：通过索引获取值
 *
 * @author lujinpeng
 * @date 2023-08-31 7:12 下午
 */
public class Main {
    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] scores = new int[]{100, 99, 66};
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }
}

package _05_Arrays._5_5_Query_and_Update_Element;

/**
 * 用自己的 Array 进行测试体验
 *
 * @author lujinpeng
 * @date 2023-09-01 11:00 上午
 */
public class Main {
    public static void main(String[] args) {

        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
    }
}

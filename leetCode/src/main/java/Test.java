import java.sql.SQLOutput;

/**
 * @author lujinpeng
 * @date 2023-06-14 9:43 下午
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(-4<<2);  // -16
        System.out.println(-4>>1);  // -2
        
        System.out.println(-4>>>1);  // 2147483646
        System.out.println(4>>>1);  // 2

        Integer.valueOf(3);
    }
}

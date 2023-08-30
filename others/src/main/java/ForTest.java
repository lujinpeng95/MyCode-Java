import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author lujinpeng
 * @date 2023-08-28 2:56 下午
 */
public class ForTest {
    public static void main(String[] args) {
        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2

        List arr3 = Arrays.asList(1, 2);
        System.out.println(arr3.size());//2

        HashMap temp = new HashMap();
        Object tmp;
    }
}

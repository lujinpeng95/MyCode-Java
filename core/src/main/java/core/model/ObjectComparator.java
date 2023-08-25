package core.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 比较器（替换比较规则）
 *
 * @author lujinpeng
 * @date 2023-08-25 10:55 上午
 */
public class ObjectComparator implements Comparator<ComparableObject> {

    @Override
    public int compare(ComparableObject o1, ComparableObject o2) {
        return Integer.compare(o1.getValue(),  o2.getValue());
    }

    public static void main(String[] args) {
        List<ComparableObject> list = new ArrayList<>();
        list.add(ComparableObject.builder().value(3).build());
        list.add(ComparableObject.builder().value(1).build());

//        Collections.sort(list, new ObjectComparator());
        list.sort(new ObjectComparator());
        System.out.println(list);
    }
}

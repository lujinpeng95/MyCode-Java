package core.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 可用于比较的对象
 *
 * @author lujinpeng
 * @date 2023-08-25 10:51 上午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ComparableObject implements Comparable<ComparableObject> {

    private int value;

    @Override
    public int compareTo(ComparableObject other) {
        return Integer.compare(this.value, other.value);
    }

}

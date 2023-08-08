package 重写toString为Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:53 下午
 */
public class Solution01 {
    private String field1;
    private int field2;

    // 构造函数，getters，setters 等...
    public Solution01(String name, int age) {
        this.field1 = name;
        this.field2 = age;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static void main(String[] args) {
        Solution01 solution01 = new Solution01("John Doe", 30);
        System.out.println(solution01);
    }
}

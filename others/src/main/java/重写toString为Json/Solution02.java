package 重写toString为Json;

import com.google.gson.Gson;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:53 下午
 */
public class Solution02 {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);
        System.out.println(person);
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json);
    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getters and setters

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

package 通过反射调用方法;

import java.lang.reflect.Method;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:32 下午
 */
public class Solution01 {
    public static void main(String[] args) {
        try {
            // 创建一个对象
            MyClass obj = new MyClass();

            // 获取对象的类
            Class<?> clazz = obj.getClass();

            // 获取需要调用的方法，"myMethod" 是方法的名称
            Method method = clazz.getMethod("myMethod", String.class);

            // 调用方法
            method.invoke(obj, "Hello, World!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


class MyClass {
    // 这是我们将通过反射调用的方法
    public void myMethod(String message) {
        System.out.println("My Method Called! Message: " + message);
    }
}



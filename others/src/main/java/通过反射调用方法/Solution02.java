package 通过反射调用方法;

import java.lang.reflect.Method;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:32 下午
 */
public class Solution02 {
    public static void main(String[] args) throws Exception {
        // 获取方法所在的类
        MyClass2 obj = new MyClass2();
        Class<?> clazz = obj.getClass();

        // 获取方法
        Method method = clazz.getDeclaredMethod("myMethod");

        // 调用方法
        method.invoke(obj);
    }
}

class MyClass2 {
    public void myMethod() {
        System.out.println("Hello, world!");
    }
}

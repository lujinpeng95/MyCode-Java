package core.util;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 反射相关代码
 * @author lujinpeng
 * @date 2024-07-29 14:38
 */
@Slf4j
public class ReflectUtils {

    /**
     * 表名
     */
    public static final String TABLE_NAME = "tableName";

    /**
     * 类名
     */
    public static final String CLASS_NAME = "className";

    /**
     * 通过反射将 class1不为空的值赋值给class2
     *
     * @param class1 当前对象
     * @param class2 目标对象
     */
    public static void reflectClass1ToClass2(Object class1, Object class2) throws Exception {
        Field[] field = class2.getClass().getDeclaredFields();
        for (Field item : field) {
            String name = item.getName();
            if ("serialVersionUID".equals(name)) {
                continue;
            }
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method m1 ;
            try {
                m1 = class1.getClass().getMethod("get" + name);
            } catch (Exception e) {
                continue;
            }
            Object value = m1.invoke(class1);
            if (value != null) {
                item.setAccessible(true);
                item.set(class2, value);
            }
        }
    }

    /**
     * 通过获取类上的@TableName注解 获取表名称、类名称
     *
     * @param clazz 类名称
     * @return Map<String, String> 表名与类名
     */
    public static Map<String, String> getTableName(Class<?> clazz) {
        Map<String, String> map = new ConcurrentHashMap<>();
        TableName annotation = clazz.getAnnotation(TableName.class);
        String name = annotation.value();
        String className = clazz.getSimpleName();
        map.put(TABLE_NAME, name);
        map.put(CLASS_NAME, className);
        return map;
    }

    /**
     * 获取类名称
     *
     * @param clazz 类名称
     * @return Map<String, String> 表名与类名
     */
    public static Map<String, String> getClassName(Class<?> clazz) {
        Map<String, String> map = new ConcurrentHashMap<>();
        String className = clazz.getSimpleName();
        map.put(CLASS_NAME, className);
        return map;
    }

    /**
     * 调用指定类中的方法，并返回方法执行结果列表
     *
     * @param clazz 类对象
     * @param methodNames 方法名列表
     * @param methodParams 方法参数列表
     * @return 方法执行结果列表
     */
    public static List<Object> invokeMethods(Class<?> clazz, List<String> methodNames, List<List<Object>> methodParams) {
        List<Object> results = new ArrayList<>();
        Object instance = null;

        try {
            for (int i = 0; i < methodNames.size(); i++) {
                String methodName = methodNames.get(i);
                List<Object> params = methodParams.get(i);

                if (methodName.equals(clazz.getSimpleName())) {
                    Constructor<?> constructor = clazz.getConstructor();
                    // 设置可访问
                    constructor.setAccessible(true);
                    instance = constructor.newInstance();
                    // Constructor does not return a value
                    results.add(null); 
                } else {
                    Method method = findMethod(clazz, methodName, params);
                    // 设置可访问
                    method.setAccessible(true);
                    Object result = method.invoke(instance, params.toArray());

                    // 处理数组返回值
                    if (result != null && result.getClass().isArray()) {
                        results.add(ArrayUtil.nestedToString(result));
                    } else {
                        results.add(result);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    /**
     * 查找指定类中的方法
     *
     * @param clazz   待查找方法的类
     * @param methodName 方法名
     * @param params 方法参数列表
     * @return 查找到的方法对象
     * @throws NoSuchMethodException 如果找不到符合条件的方法，则抛出 NoSuchMethodException 异常
     */
    private static Method findMethod(Class<?> clazz, String methodName, List<Object> params) throws NoSuchMethodException {
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(methodName) && method.getParameterCount() == params.size()) {
                boolean matches = true;
                for (int j = 0; j < params.size(); j++) {
                    if (!method.getParameterTypes()[j].isAssignableFrom(params.get(j).getClass())) {
                        matches = false;
                        break;
                    }
                }
                if (matches) {
                    return method;
                }
            }
        }
        throw new NoSuchMethodException("No suitable method found for " + methodName);
    }

}


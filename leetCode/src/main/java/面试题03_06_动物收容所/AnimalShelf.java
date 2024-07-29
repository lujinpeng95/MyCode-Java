package 面试题03_06_动物收容所;

import core.util.ArrayUtil;
import core.util.ReflectUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：
 * 有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。
 * 在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。
 * 换言之，收养人不能自由挑选想收养的对象。
 * 请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 *
 * enqueue方法有一个animal参数，animal[0]代表动物编号（按收容顺序递增），animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 *
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * 
 * 考察点：
 * LinkedList操作：isEmpty()、peek()、offer()、poll()
 * 
 * @author lujinpeng
 * @date 2024-07-26 17:23
 */
class AnimalShelf {

    Queue<Integer> queueCat;
    Queue<Integer> queueDog;

    public AnimalShelf() {
        queueCat = new LinkedList<>();
        queueDog = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            queueCat.offer(animal[0]);
            return;
        }

        queueDog.offer(animal[0]);
    }

    public int[] dequeueAny() {

//        if (queueDog.isEmpty()) {
//            return this.dequeueCat();
//        }
//        if (queueCat.isEmpty()) {
//            return this.dequeueDog();
//        }
//        if (queueDog.peek() < queueCat.peek()) {
//            return new int[]{queueDog.poll(), 1};
//        
//        return new int[]{queueCat.poll(), 0};

        int catId = !queueCat.isEmpty() ? queueCat.peek() : Integer.MAX_VALUE;
        int dogId = !queueDog.isEmpty() ? queueDog.peek() : Integer.MAX_VALUE;

        if ((catId == Integer.MAX_VALUE) && (dogId == Integer.MAX_VALUE)) {
            // 两种动物均为空
            return new int[]{-1, -1};
        }

        if (catId < dogId) {
            // 猫进入队列时间更长
            return new int[]{queueCat.poll(), 0};
        }

        return new int[]{queueDog.poll(), 1};
    }

    public int[] dequeueDog() {
        return queueDog.isEmpty() ? new int[]{-1, -1} : new int[]{queueDog.poll(), 1};
    }

    public int[] dequeueCat() {
        return queueCat.isEmpty() ? new int[]{-1, -1} : new int[]{queueCat.poll(), 0};
    }


    public static void main(String[] args) {
        
        List<String> methodNames = Arrays.asList("AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny");
        List<List<Object>> methodParams = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(new int[]{0, 0}),
                Arrays.asList(new int[]{1, 0}),
                Arrays.asList(new int[]{2, 1}),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
        List<Object> results = ReflectUtils.invokeMethods(AnimalShelf.class, methodNames, methodParams);
    
        System.out.println("输入：\n" + ArrayUtil.nestedToString(methodNames) + "\n" + ArrayUtil.nestedToString(methodParams));
        System.out.println("输出：\n" + results);

    }

    
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */

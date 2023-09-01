package _05_Arrays._5_7_Generic_Data_Structures;

import core.model.Student;

/**
 * 用自己的 Array 进行测试体验 --- 泛型
 *
 * @author lujinpeng
 * @date 2023-09-01 11:00 上午
 */
public class Main {
    public static void main(String[] args) {

        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        /**************************/
        Array<Student> students = new Array<>();
        students.addLast(new Student("Alice", 100));
        students.addLast(new Student("Bob", 66));
        students.addLast(new Student("Charlie", 88));
        System.out.println(students);

    }
}

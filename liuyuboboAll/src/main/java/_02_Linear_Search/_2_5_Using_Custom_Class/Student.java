package _02_Linear_Search._2_5_Using_Custom_Class;

public class Student {

    private String name;

    public Student(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object student){
        // 地址
        if(this == student) {
            return true;
        }

        // 判null
        if(student == null) {
            return false;
        }

        // 判类型
        if(this.getClass() != student.getClass()) {
            return false;
        }

        Student another = (Student)student;
        // 比较算法
        return this.name.equals(another.name);
    }
}

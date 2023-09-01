package core.model;

public class Student implements Comparable<Student>{

    private String name;

    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
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

    @Override
    public int compareTo(Student another) {

//        if (this.score < another.score) {
//            return -1;
//        } else if (this.score == another.score) {
//            return 0;
//        } else {
//            return 1;
//        }

        return this.score - another.score;
    }

    @Override
    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", score=" + score +
//                '}';
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}

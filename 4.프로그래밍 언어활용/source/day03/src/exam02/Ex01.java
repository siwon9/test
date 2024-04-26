package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(1000,"naname","JAVA");
        Student s2 = new Student (1001,"imname", "react");

        System.out.println("s1:"+s1); // s1.id = 1000
        System.out.println("s2:"+s2); // s2.id = 1001

        System.out.println(s1.id); // Student.id로 적는걸 권장 '햇갈리니까'
        System.out.println(s2.id);

        Student.staticMethod();
    }
}

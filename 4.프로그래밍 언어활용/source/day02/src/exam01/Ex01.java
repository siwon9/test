package exam01;

public class Ex01 {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.id = 1000; // 인스턴스 변수
        s1.name = "siwon";
        s1.subject = "JAVA";
        System.out.println(s1.id);
        s1.study();

        Student s2=new Student();
        s2.id = 1001;
        s2.name = "name";
        s2.subject = "JavaScript";

        Student s3 = s2;
        s3.name = "rladlfma";
        s3.study();

        s2.study();

        s1 =null;
        s1.study();


    }
}

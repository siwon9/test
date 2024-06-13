package MyArray;

public class Q3 {
    private int studentID;
    private String name;

    public Q3 () {

    };

    public Q3 (int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void showStudentInfo() {
        System.out.println(studentID + ", " + name );
    }

}

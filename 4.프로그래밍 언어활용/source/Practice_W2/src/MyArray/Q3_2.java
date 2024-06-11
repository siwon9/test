package MyArray;

import java.util.ArrayList;

public class Q3_2 {
    public static void main(String[] args) {
        ArrayList<Q3> myStudent = new ArrayList();
        myStudent.add(new Q3(1001,"James"));
        myStudent.add(new Q3(1002,"Tomas"));
        myStudent.add(new Q3(1003,"Edward"));

        for(int i=0; i < myStudent.size(); i++) {
            myStudent.get(i).showStudentInfo();
        }
    }
}

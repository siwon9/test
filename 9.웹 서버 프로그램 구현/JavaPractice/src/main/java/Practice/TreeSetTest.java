package Practice;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("홍길동1");
        treeSet.add("홍길동3");
        treeSet.add("홍길동2");

        for(String str : treeSet) {
            System.out.println(str);
        }
    }
}

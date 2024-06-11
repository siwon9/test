package ArrayPractice;

import java.util.ArrayList;

public class Q5 {
    public static void main(String[] args) {
        ArrayList<Q4> list = new ArrayList<Q4>();
        list.add(new Q4("멍1", "귀"));
        list.add(new Q4("멍2", "여"));
        list.add(new Q4("멍3", "운"));
        list.add(new Q4("멍4", "강"));
        list.add(new Q4("멍5", "쥐"));

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).showDogInfo());
        }
    }
}

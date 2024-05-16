package Question;

// 오늘 해야 할 일이 담긴 문자열 배열 todo_list와 각각의 일을
// 지금 마쳤는지를 나타내는 boolean 배열 finished가 매개변수로 주어질 때,
// todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는
// solution 함수를 작성해 주세요.

import java.util.ArrayList;

public class Q5 {
    public static void main(String[] args) {
        String[] todo_list = {"task1","task2","task3","task4","task5"};
        Boolean[] finished = {false,true,false,true,false};

    }

    public static solution(String[] todo_list, Boolean[] finished) {
        ArrayList<String> unfinished = new ArrayList<>();

        for(int i=0; i<todo_list.length; i++) {
            if(!finished[i]) {
                unfinished.add(todo_list[i]);
            }
        }
            return unfinished.toArray();
    }
}

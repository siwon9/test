package exam01;

public class Board {

    // private static Board instance = new Board (); // 클래스 로드 시점부터 객체를 생성한다.
    // static에서 정의된 것에서 어떻게 생성이되지? new 생성자는 이미 생성된 객체를 새로운객체로 생성하는거아닌가?
    // 변수를 할당받고 힙메모리에 저장이 됨

    private static Board instance;


    private Board() {}

    public static Board getInstance() {
        if(instance==null){
            instance = new Board();
        }
        return instance;
    }
}


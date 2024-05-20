package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Ex01_1 th = new Ex01_1();
        // th.run();
        th.start();

        for (int i =0; i<5; i++) {
            System.out.println("메인 쓰레드 - " + i);
        }
    }
}

// Thread를 상속받는 방법은 유연성에서 불리하다. 상속은 1개만 받을 수 있기 때문이다.
// 실무에서는 사용을 많이 하지 않는다.

class Ex01_1 extends Thread{
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(getName() + " - " + i);
        }
    }
}

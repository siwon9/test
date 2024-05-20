package exam01;

import java.sql.SQLOutput;

public class Ex07 {
    public static void main(String[] args) throws InterruptedException{
        Thread th = new Thread(() -> {
            Thread th2 = Thread.currentThread();
            while(true) {

            try {
                System.out.println("isInterrupted : "+ th2.isInterrupted());
                Thread.sleep(10000); // WAITING - 일시 정지
                // interrupted() -> InterruptedException 발생, isInterrupted - false로 바뀜

            } catch(InterruptedException e) { // RUNNABLE - 실행 대기
                System.out.println("InterruptedException 발생!");
                th2.interrupt();
            }
            }
        });

            th.start();
            Thread.sleep(3000);
            th.interrupt(); // interruptedException 발생, isInterrupted --> true 로 바꿔줌
    }
}

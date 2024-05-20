package exam01;

public class Ex06 {
    public static void main(String[] args) {
        Thread th = new Thread(() -> {
            Thread th2 = Thread.currentThread();
            int num = 0;
            while(!th2.isInterrupted()) {
                System.out.println(num++);
                for(long j = 0; j < 1_000_000_000L; j++);
            }
        });

        th.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {} // 멈춰있다가 깨어나면 이 예외가 발생해서 깨우니까 예외처리를 해줘야만함
        th.interrupt(); // isInterrupted() -> true
    }
}
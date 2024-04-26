package exam03;

public class Tiger extends Animal{
    @Override
    public void move(){
        System.out.println("네발로 걸어다닌다.");
    }

    public void hunting() {
        System.out.println("사냥을 한다.");
    }


    /*@Override
    public void move() {
        super.move(); } // 상속받은 Animal의 move를 가져오기 */
    }

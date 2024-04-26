package exam01;

public class Ex03 {
    public static void main(String[] args) {
        //int num3 = 30;
        Calculator cal = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                // num3 = 50; 지역변수의 상수화 때문에 값을 바꿀 수 없음
                return num1 + num2;
            }
        };
        Calculator cal2 = (x,y) -> x+y;
    }
}

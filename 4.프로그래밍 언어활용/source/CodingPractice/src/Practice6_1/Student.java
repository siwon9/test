package Practice6_1;

public class Student {
    private String name;
    private int studentMoney;


    public Student(String name, int studentMoney) {
        this.name = name;
        this.studentMoney = studentMoney;
    }

    public void takeTaxi(int studentMoney) {
        //Taxi.take(10000);
        this.studentMoney -= 10000;
    }
}

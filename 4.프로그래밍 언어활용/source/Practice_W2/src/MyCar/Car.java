package MyCar;

public abstract class Car {
    public void start() {}
    public void drive() {}
    public void stop() {}
    public void turnoff() {}
    public void washCar() {
        System.out.println("세차를 합니다.");
    }


     final public void run () {
        start();
        drive();
        stop();
        turnoff();
        washCar();
    }
}

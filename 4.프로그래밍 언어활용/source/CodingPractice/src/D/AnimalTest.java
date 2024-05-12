package D;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest aTest = new AnimalTest();
        aTest.moveAnimal(new Human());
        aTest.moveAnimal(new Tiger());
    }

    public void moveAnimal(Animal animal) {
        animal.move();


    }
}

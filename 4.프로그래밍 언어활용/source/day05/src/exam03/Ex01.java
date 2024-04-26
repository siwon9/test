package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Human human = new Human(); // Animal , Human 가능
        human.move();

        Tiger tiger = new Tiger();
        tiger.move();

        Bird bird = new Bird();
        bird.move();

        Animal[] animals = new Animal[3];
//        animals[0] = human;
//        animals[1] = tiger;

    for (Animal animal : animals){
        animal.move();
        }
    }
}

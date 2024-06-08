package Practice;

public class P3 {
    String name;
    float height;
    float weight;

    public P3() {}

    public P3(String name){
        this.name = name;
    }

    public P3(String name, float height, float weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "P3{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}


package MyGenerics;

public class Plastic<T> {
    private T material;

    public void setMaterial(T material) {
        this.material = material;
    }

    public T getMeterial() {
        return material;
    }

    public String toString() {
        return material.toString();
    }
}

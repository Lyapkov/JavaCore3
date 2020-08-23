package Lesson1.Task3;

public abstract class Fruit <T extends Number> {
    private T weight;

    Fruit(T weight) {
        this.weight = weight;
    }

    public T getWeight() {
        return weight;
    }
}

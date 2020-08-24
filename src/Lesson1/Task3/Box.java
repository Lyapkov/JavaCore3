package Lesson1.Task3;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<T>();
    private float weight;

    public void addFruit(T fruit) {
        fruits.add(fruit);
        weight += (float) fruit.getWeight();
    }

    public float getWeight() {
        return weight;
    }

    public boolean compare(Box box) {
        if (Math.abs(this.weight - box.getWeight()) < 0.0000001f) {
            return true;
        }
        return false;
    }

    public void shift(Box box) {
        for (int i = (box.getFruits().size() - 1); i >= 0; i--) {
            this.addFruit((T)box.getFruits().get(i));
            box.getFruits().remove(i);
        }
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void print(){
        for (T o: fruits) {
            System.out.println(o);
        }
    }
}

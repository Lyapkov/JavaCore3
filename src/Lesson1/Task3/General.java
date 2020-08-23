package Lesson1.Task3;

public class General {

    public static void main(String[] args) {
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Box<Orange> box1 = new Box<Orange>();
        box1.addFruit(orange1);
        box1.addFruit(orange2);
        box1.addFruit(orange3);
        Box<Apple> box2 = new Box<Apple>();
        box2.addFruit(apple1);
        box2.addFruit(apple2);
        box2.addFruit(apple3);
        System.out.println(box1.compare(box2));
        box1.print();
        box2.print();
        box1.shift(box2);
        box1.print();
        //box2.print();
    }

}

package Lesson1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Task2 {

    public static void main(String[] args) {
        String[] arr = new String[] {"A", "B", "C", "D"};
        print(transfer(arr));
    }

    private static <T> ArrayList transfer(T[] array) {
        ArrayList<T> arrayList = new ArrayList();
        for (T o: array) {
            arrayList.add(o);
        }
        return arrayList;
    }

    private static <T> void print(ArrayList<T> arrayList) {
        for (T o: arrayList) {
            System.out.println(o);
        }
    }
}

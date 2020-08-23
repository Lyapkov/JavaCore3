package Lesson1;

public class Task1 {

    public static void main(String[] args) {
        String[] array = new String[]{"A", "B", "C", "D", "E"};
        print(array);
        print(change(array, 2, 3));
    }

    private static <T> T[] change(T[] arr, int a, int b) {
        T array = arr[a];
        arr[a] = arr[b];
        arr[b] = array;
        return arr;
    }

    private static <T> void print(T[] arr) {
        for (T o: arr) {
            System.out.println(o);
        }
    }
}

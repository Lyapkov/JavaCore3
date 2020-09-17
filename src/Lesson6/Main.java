package Lesson6;

public class Main {

    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3, 4, 5, 6};
            for (int value : task1(arr))
                System.out.println(value);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        System.out.println(task2(new int []{1, 1, 4}));
        System.out.println(task2(new int []{1, 1}));
        System.out.println(task2(new int []{4}));
        System.out.println(task2(new int []{1, 2, 4}));
    }

    public static int[] task1(int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                index = i;
            }
        }
        if (index == -1)
            throw new RuntimeException();
        int[] result = new int[arr.length - (index + 1)];
        for (int i = 0; i < result.length; i++)
            result[i] = arr[index + i + 1];
        return result;
    }

    public static boolean task2(int[] arr) {
        boolean goodArr = false;
        int one = arr[0];
        for (int value: arr) {
            if (value != 1 && value != 4)
                return false;
            if (one != value)
                goodArr = true;
        }
        return goodArr;
    }

}

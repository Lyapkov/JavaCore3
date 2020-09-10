package Lesson4;

public class Main {
    private final Object mon = new Object();
    private static String currentLetter = "A";

    public static void main(String[] args) {
        Main main = new Main();
        new Thread(main::printA).start();
        new Thread(main::printB).start();
        new Thread(main::printC).start();
    }

    private void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != "A") {
                            mon.wait();
                    }
                    System.out.print("A");
                    currentLetter = "B";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != "B") {
                            mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = "C";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != "C") {
                            mon.wait();
                    }
                    System.out.println("C");
                    currentLetter = "A";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

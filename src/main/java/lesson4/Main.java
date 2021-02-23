package lesson4;

public class Main {

    static final Object mon = new Object();
    static String currentLetter = "A";

    public static void main(String[] args) {

        System.out.println("Начало работы");
        // вывод буквы 'А'
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        // ждем, пока символ символ не равен А
                        while (!currentLetter.equals("A")) {
                            mon.wait();
                        }
                        System.out.println(currentLetter);
                        currentLetter = "B";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // вывод буквы 'B'
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        // ждем, пока символ символ не равен А
                        while (!currentLetter.equals("B")) {
                            mon.wait();
                        }
                        System.out.println(currentLetter);
                        currentLetter = "C";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // вывод буквы 'C'
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        // ждем, пока символ символ не равен А
                        while (!currentLetter.equals("C")) {
                            mon.wait();
                        }
                        System.out.println(currentLetter);
                        currentLetter = "A";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /*// вывод символа 'А'
    public void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    // ждем, пока символ символ не равен А
                    while (!currentLetter.equals("А")) {
                        mon.wait();
                    }
                    System.out.println(currentLetter);
                    currentLetter = "B";
                    mon.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // вывод символа 'B'
    public void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    // ждем, пока символ символ не равен А
                    while (!currentLetter.equals("B")) {
                        mon.wait();
                    }
                    System.out.println(currentLetter);
                    currentLetter = "C";
                    mon.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // вывод символа 'C'
    public void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    // ждем, пока символ символ не равен А
                    while (!currentLetter.equals("C")) {
                        mon.wait();
                    }
                    System.out.println(currentLetter);
                    currentLetter = "A";
                    mon.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}

package task_02;

public class Counter {

    // all threads work with this variable
    public static int counter;

    public static void main(String[] args) {

        MyThread myThread1 = new MyThread(); // create thread1
        MyThread myThread2 = new MyThread(); // create thread2

        myThread1.start(); // start is method of Tread
        myThread2.start();

        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }

        // How many threads are running?
        // main, myThread1 and myThread2

        //
        try {
            myThread1.join(); //  заставляет основной поток (main thread) ждать завершения thread1
            myThread2.join(); //  заставляет основной поток (main thread) ждать завершения thread2
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value: " + counter); // main thread finish when thread1 and thread2 are finished
        //
    }
}
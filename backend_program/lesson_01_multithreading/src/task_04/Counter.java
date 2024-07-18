package task_04;

public class Counter {

    public static void main(String[] args) {

        // Два базовых способа создания отдельного потока:
        // 1. Использование класса Thread
        // 2. Использование интерфейса Runnable

        MyThread1Extends myThread1Extends = new MyThread1Extends();
        MyThread2Runnable myThread2Runnable = new MyThread2Runnable();
        Thread thread = new Thread(myThread2Runnable);

        thread.setDaemon(true);

        myThread1Extends.start();
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
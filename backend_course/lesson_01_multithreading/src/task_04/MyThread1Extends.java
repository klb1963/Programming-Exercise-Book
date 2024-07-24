package task_04;

public class MyThread1Extends extends Thread {

    @Override
    public void run() {
        for (int i = 100; i < 110; i++) {
            System.out.println(getName() + " " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
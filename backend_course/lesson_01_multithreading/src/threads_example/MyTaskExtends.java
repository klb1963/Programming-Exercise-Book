package threads_example;

public class MyTaskExtends extends Thread { // create class extends from Thread
    // fields
    String name;
    int max;

    // constructor
    public MyTaskExtends(String name, int max) {
        this.name = name;
        this.max = max;
    }

    // method from Thread
    @Override
    public void run() {
        System.out.println(name + " task started"); // just information
        for (int i = 0; i < max; i++) {
            System.out.println("Task " + name + ", count = " + i); // tracking task
            try {
                Thread.sleep(1); // stop thread for 1 mills
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " task finished.");
    }
}

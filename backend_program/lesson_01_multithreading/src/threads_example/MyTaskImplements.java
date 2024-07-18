package threads_example;

public class MyTaskImplements implements Runnable { // implements from Runnable
    String name;
    int max;

    public MyTaskImplements(String name, int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        System.out.println(name + " task started");
        for (int i = 0; i < max; i++) {
            System.out.println("Task " + name + ", count = " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " task finished.");
    }
}

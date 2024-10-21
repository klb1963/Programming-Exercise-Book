package list_vs_linked_performance.ait.list;

import java.util.*;

public class ListPerfomanceTest {
    private static final int N_NUMBERS = 500_000;
    private static final Random random = new Random();
    private static final int MIN = 10;
    private static final int MAX = 20;

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        fillCollection(list);
        System.out.println("=== Foreach ===");
        long t1 = System.currentTimeMillis();
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("sum = " + sum);
        System.out.println("duration = " + (t2 - t1));

        System.out.println("=== Iterator ===");
        t1 = System.currentTimeMillis();
        sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        t2 = System.currentTimeMillis();
        System.out.println("sum = " + sum);
        System.out.println("duration = " + (t2 - t1));

        System.out.println("=== For loop ===");
        t1 = System.currentTimeMillis();
        sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("sum = " + sum);
        System.out.println("duration = " + (t2 - t1));
    }

    private static void fillCollection(List<Integer> list) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < N_NUMBERS; i++) {
            list.add(random.nextInt(MIN, MAX));
        }
        long t2 = System.currentTimeMillis();
        System.out.println("duration of fillCollection = " + (t2 - t1));
    }
}

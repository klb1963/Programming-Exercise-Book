package treeset;

import java.util.TreeSet;

public class TreeSetExampleNumber {
    public static void main(String[] args) {

        // загрузить в TreeSet 10 случайных целых чисел и понять:
        // - это Set?
        // - имеется ли порядок в этом множестве?

        TreeSet<Integer> numbers = new TreeSet<>();
        // add elements
        numbers.add(8);
        numbers.add(-7);
        numbers.add(15);
        numbers.add(41);
        numbers.add(65);
        numbers.add(245);
        numbers.add(69);
        numbers.add(987);
        numbers.add(-7);
        numbers.add(245);

        // elements of TreeSet
        System.out.println(numbers);
        numbers.remove(245);
        System.out.println(numbers);
        System.out.println("-------------------------");
        System.out.println(numbers.contains(15));

        System.out.println("=======================");
        System.out.println(numbers.floor(50));

        // TODO - try other methods

    }
}

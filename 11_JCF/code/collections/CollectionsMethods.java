package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsMethods {
    public static void main(String[] args) {
        // Создайте список известных вам фруктов. +
        // Выполните поиск имеющегося и отсутствующего элемента списка. +
        // Отсортируйте этот список по алфавиту в прямом и обратном порядке. +
        // Проверьте работу методов
        // max(Collection<?> coll)
        // min(Collection<?> coll), что они возвращают?

        List<String> fruits = new ArrayList<>();
        
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("kiwi");
        fruits.add("grapefruit");
        fruits.add("grape");
        fruits.add("apricot");
        fruits.add("peach");
        
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        Collections.sort(fruits); // sorting

        System.out.println("---------------------------");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        String str = "ccc";
        int index = Collections.binarySearch(fruits, str);
        System.out.println( str + " is stays on index: " + index);

        Comparator<String> fruitComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return - o1.compareTo(o2);
            }
        };

        Collections.sort(fruits, fruitComparator);
        System.out.println("---------------------------");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        String max = Collections.max(fruits);
        System.out.println("Max of collection: " + max);
        String min = Collections.min(fruits);
        System.out.println("Mix of collection: " + min);

        Collections.shuffle(fruits);
        System.out.println("---------------------------");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        Collections.reverse(fruits);
        System.out.println("---------------------------");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

    }
}

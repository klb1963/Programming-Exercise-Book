package list_vs_linked_performance.ait.list;

import java.util.*;

public class ListAppl {
    private static final int N_NUMBERS = 10;
    private static final Random random = new Random();
    private static final int MIN = 10;
    private static final int MAX = 20;

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        fillCollection(list);
        printList(list);
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
//        list.clear();
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());

//        System.out.println(list.indexOf(15));
//        System.out.println(list.lastIndexOf(15));
//        System.out.println(list.set(0, 42));
//        printList(list);
//        System.out.println(list.get(0));

//        NB! Wrong way!
//        for (Integer num : list) {
//            if (num.equals(15)) {
//                list.remove(num);
//            }
//        }

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            Integer num = iterator.next();
//            if(num.equals(15)){
//                iterator.remove();
//            }
//        }

//        list.removeIf(n -> n.equals(15));
        list.removeIf(n -> n >= 18 || n <= 12);

        printList(list);
    }

    private static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.print(num + "\t");
        }
        System.out.println("\n===================================");
    }

    private static void fillCollection(List<Integer> list) {
        for (int i = 0; i < N_NUMBERS; i++) {
            list.add(random.nextInt(MIN, MAX));
        }
    }
}

package ait.list;

import ait.list.interfaces.IList;
import ait.list.model.MyArrayList;

import java.util.Iterator;

public class ListAppl {
    public static void main(String[] args) {
        IList<Integer> list = new MyArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(7);
        list.add(null);
        System.out.println(list.size());
        System.out.println(list.get(2));
        System.out.println(list.get(5));
        try {
            System.out.println(list.get(10));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list.indexOf(3));
        System.out.println(list.indexOf(7));
        System.out.println(list.indexOf(null));
        System.out.println(list.indexOf(10));
        Integer num = list.remove(5);
        System.out.println(num);
        System.out.println(list.size());
        System.out.println(list.remove((Integer)7));
        System.out.println(list.size());
        System.out.println("=== Homework ===");
        list.add(4, 13);
        System.out.println(list.size());
        System.out.println(list.get(4));
        for (Integer n : list) {
            System.out.println(n);
        }
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println("===== List of String =====");
        IList<String> myList = new MyArrayList<>();
        myList.add("Boston");
        myList.add("Atlanta");
        myList.add("Chicago");
        myList.add("Boston");
        myList.add("New York");
        Iterator<String> iterator = myList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

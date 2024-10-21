package set;

import set.interfaces.ISet;
import set.model.MyHashSet;

public class MyHashSetAppl {
    public static void main(String[] args) {
        ISet<String> mySet = new MyHashSet<>();
        mySet.add("Boston");
        mySet.add("Atlanta");
        System.out.println(mySet.size());
        System.out.println(mySet.add("Chicago"));
        System.out.println(mySet.size());
        System.out.println(mySet.add("Chicago"));
        System.out.println(mySet.size());
        mySet.add("New York");
        mySet.add("Detroit");
        System.out.println(mySet.size());
        System.out.println("=== Contains ===");
        System.out.println(mySet.contains("Chicago"));
        System.out.println(mySet.contains("Dallas"));
        System.out.println("=== Remove ===");
        System.out.println(mySet.remove("Boston"));
        System.out.println(mySet.contains("Boston"));
        System.out.println("=== Iterator ===");
        for (String str : mySet){
            System.out.println(str);
        }
    }
}

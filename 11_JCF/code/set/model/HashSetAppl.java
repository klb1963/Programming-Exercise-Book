package set.model;

import set.interfaces.ISet;

import java.util.HashSet;
import java.util.Set;

public class HashSetAppl {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();
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

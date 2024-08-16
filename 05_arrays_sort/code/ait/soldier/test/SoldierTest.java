package ait.soldier.test;

import ait.soldier.model.Soldier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SoldierTest {
    Soldier[] soldiers;

    @BeforeEach
    void setUp() {
        soldiers = new Soldier[]{
                new Soldier("John", 182, 82.3, 91),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("Robin", 162, 55.1, 91),
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Ann", 162, 55, 88)
        };
    }

    @Test
    void testSortSoldiersNaturalOrder() {
//        int t = soldiers[3].compareTo(soldiers[1]);
        Arrays.sort(soldiers);
//        System.out.println(Arrays.toString(soldiers));
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByName() {
        Arrays.sort(soldiers, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByProfile() {
        Arrays.sort(soldiers, (s1, s2) -> {
            int res = s2.getProfile() - s1.getProfile();
            return res != 0 ? res : s1.getHeight() - s2.getHeight();
        });
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByWeight() {
        Arrays.sort(soldiers, (s1, s2) -> Double.compare(s1.getWeight(), s2.getWeight()));
        printArray(soldiers);
    }

    //sorting Integer objects
    @Test
    void testSortIntegerDesc() {
        Integer[] array = {-1, Integer.MIN_VALUE, Integer.MAX_VALUE}; // 3 numbers in a wrong order
        Integer[] expected = {Integer.MAX_VALUE, -1, Integer.MIN_VALUE}; // expecting order
        Arrays.sort(array, (n1, n2) -> Integer.compare(n2, n1)); // sort array
        assertArrayEquals(expected, array); // check result
    }

    // use binarySearch
    @Test
    void testArraysBinarySearch(){
        printArray(soldiers);
        System.out.println("------------------------------------");
        Arrays.sort(soldiers, (s1, s2)-> (s1.getProfile() - s2.getProfile()));
        printArray(soldiers);
        Soldier pattern = new Soldier(null, 0, 0, 88); // who's searching
        int index = Arrays.binarySearch(soldiers,pattern, (s1, s2)-> (s1.getProfile() - s2.getProfile())); // search
        System.out.println(index);

    }


    private void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("=====================================");
    }
}

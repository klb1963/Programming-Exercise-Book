package myarray_iterator;

import myarray_iterator.model.MyArray;

import java.util.Iterator;

public class MyArrayAppl {
    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MyArray myArray = new MyArray(array);
        System.out.println(myArray);

        Iterator<Integer> iterator = myArray.iterator();

        //print negative elements
        System.out.println("=============Negative values============");
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.print(i * -1 + "| ");
        }
        System.out.println();

        iterator = myArray.iterator(); //reset index

        //square all elements
        System.out.println("=============Square all================");

        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.print(i * i + "| ");
        }
        System.out.println();

        //removes even numbers from array
        System.out.println("=============Print array as is================");
        for (Integer i : myArray) {
            System.out.print(i + "| ");
        }
        System.out.println();
        System.out.println("---------------------------------------------------");
        iterator = myArray.iterator(); //reset index
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num % 2 == 0) {
                iterator.remove();
            }
        }

        for (Integer i : myArray) {
            System.out.print(i + " | ");
        }

    }
}

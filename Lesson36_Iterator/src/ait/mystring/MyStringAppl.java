package ait.mystring;

import ait.mystring.model.MyString;

import java.util.Iterator;

public class MyStringAppl {
    public static void main(String[] args) {
        MyString myString = new MyString("Two beer, or not two beer");
        System.out.println(myString);
        myString.addChar('!');
        System.out.println(myString);
        myString.removeChar(',');
        System.out.println(myString);
        System.out.println("==========================");
        // правильный способ для удаления
        Iterator<Character> iterator = myString.iterator();
        while (iterator.hasNext()){
            char c = iterator.next();
            if (c == 'e') {
                iterator.remove();
            }
        }
        System.out.println(myString);

//        Wrong way!!!
//        for (char c: myString){
//            if (c == 'r') {
//                myString.removeChar(c);
//            }
//        }
//        System.out.println(myString);

//        for (char c : myString) {
//            System.out.println(Character.toUpperCase(c));
//        }

// Эксперимент 2.
//        Iterator<Character> iterator = myString.iterator();
//        while (iterator.hasNext()){
//            char c = iterator.next();
//            System.out.println(Character.toUpperCase(c));
//        }
//        System.out.println(myString);
//        System.out.println("==========================");
//        iterator = myString.iterator();
//        while (iterator.hasNext()){
//            char c = iterator.next();
//            System.out.println(Character.toLowerCase(c));
//        }

// Эксперимент 1.
//        StringBuilder builder = myString.getStr(); // геттер вернул ссылку на объект и предоставил весь объект
//        for (int i = 0; i < builder.length(); i++) {
//            char c = builder.charAt(i);
//            System.out.println(Character.toUpperCase(c)); // делаем какую-то операцию с элементами внутри
//        }
//        builder.setLength(3);
//        System.out.println(builder);
//        System.out.println(myString);
    }

}

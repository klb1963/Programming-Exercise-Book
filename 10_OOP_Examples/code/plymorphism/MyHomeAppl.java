package plymorphism;

import plymorphism.model.Cat;
import plymorphism.model.Dog;

public class MyHomeAppl {
    public static void main(String[] args) {

        Cat myCat = new Cat("Murka", 5, "persian", 4.5);
        Dog myDog = new Dog("Sharik", 12, "spaniel", 9);

        System.out.println("My cat name: " + myCat);
        System.out.println("Make a voice: ");
        myCat.voice();
        System.out.println(myCat);
        System.out.println("---------------------");
        System.out.println("My dog name: " + myDog);
        System.out.println("Make a voice: ");
        myDog.voice();
        System.out.println(myDog);

    }
}

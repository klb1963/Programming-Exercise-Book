package plymorphism.animal_gog_cat;

public class AnimalAppl {
    public static void main(String[] args) {

        Dog dog1 = new Dog(1, "Tarzan", 8, "German Shepherd", 50, "Woof, woof, woof");
        Dog dog2 = new Dog(2, "Charlie", 5, "Golden Retriever", 30, "Woof, woof, woof");
        Cat cat1 = new Cat(3, "Albus", 4, "Ragdoll", 10, "Meow, meow, meow", "White", 2.1);
        Cat cat2 = new Cat(4, "Cobalt", 6, "Persian", 15, "Meow, meow, meow", "Redhead", 3.0);
        Cat cat3 = new Cat(5, "Jaden", 3, "Abyssinian", 16, "Meow, meow, meow", "Black", 2.5);

        Animal[] animals = new Animal[5];
        animals[0] = dog1;
        animals[1] = dog2;
        animals[2] = cat1;
        animals[3] = cat2;
        animals[4] = cat3;


        System.out.println(cat1);
        cat1.voice();
        System.out.println("Day Routine Cat: " + cat2.getDayRoutine());
        System.out.println("-------------------------");
        System.out.println(cat2);
        cat2.voice();
        System.out.println("Day Routine Cat: " + cat2.getDayRoutine());
        System.out.println("-------------------------");
        System.out.println(cat3);
        cat3.voice();
        System.out.println("Day Routine Cat: " + cat2.getDayRoutine());
        System.out.println("-------------------------");
        System.out.print(dog1);
        dog1.voice();
        System.out.println("Day Routine Dog: " + dog1.getDayRoutine());
        System.out.println("-------------------------");
        System.out.println(dog2);
        dog2.voice();
        System.out.println("Day Routine Dog: " + dog2.getDayRoutine());


    } // end of main


} // end of class

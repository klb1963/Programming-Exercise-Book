package plymorphism.animal_gog_cat;

// Задача 1. В классе Pet имеются поля:
//id
//вид
//возраст
//кличка Создайте дочерние от класса Pet классы Cat и Dog c дополнительными полями:
//порода
//рост
//вес Создайте метод voice, который выдает "Мяу!" для класса Cat и и "Гав-гав!" для класса Dog.
// Создайте HouseAppl, в котором есть метод main. Поселите в доме 2 собаки и 3 кошки.
// Смоделируйте жизнь в этом доме в течение дня.

public class Animal {

    private int id;
    private String name;
    private int age;
    private String breed;

    public Animal(int id, String name, int age, String breed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Pet" + "\n" + "Name: " + name + "\n" + "Age: " + age + "\n" + "Breed: " + breed + "\n";
    }
}

package plymorphism.model;

public class Dog {
    private String name;
    private int age;
    private String breed;
    private double weight;

    public Dog(String name, int age, String breed, double weight) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void voice(){
        System.out.println("Gaw-gaw...");
    }
}

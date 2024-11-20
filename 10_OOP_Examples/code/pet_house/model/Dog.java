package pet_house.model;

public class Dog extends Pet {

    // Заполняем поля
    private String breed;
    private int height;
    private double weight;

    // constructor
    public Dog(int id, String species, int age, String nickname, String breed, int height, double weight) {
        super(id, species, age, nickname);
        this.breed = breed;
        this.height = height;
        this.weight = weight;
    }

    // Геттеры и сеттеры для всех полей
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Методы
    public void makeSound() {
        System.out.println(getNickname() + " " + getSpecies() + " лает: 'Гав-гав!'");
    }

    public void sleep() {
        System.out.println(getNickname() + " " + getSpecies() + " спит.");
    }

    public void eat() {
        System.out.println(getNickname() + " " + getSpecies() + " ест.");
    }

    public void play() {
        System.out.println(getNickname() + " " + getSpecies() + " играет.");
    }

    public void walk() {
        System.out.println(getNickname() + " " + getSpecies() + " гуляет.");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}'+ super.toString();
    }
}

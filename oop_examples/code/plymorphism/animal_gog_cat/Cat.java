package plymorphism.animal_gog_cat;

public class Cat extends Dog {

    private String colors;
    private double weight;

    public Cat(int id, String name, int age, String breed, int height, String voice, String colors, double weight) {
        super(id, name, age, breed, height, voice);
        this.colors = colors;
        this.weight = weight;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + "Colors: " + colors + "\n" + "Weight: " + weight + "\n" + "Cat";
    }

    public String getDayRoutine() {
        return "Wake up, Morning grooming, Dinner, Afternoon rest," +
                " Playing with toys, Cleaning, Playing with people, Nap.";


    }

    public void voice() {
        System.out.println("Meow, meow, meow.....");
    }

}

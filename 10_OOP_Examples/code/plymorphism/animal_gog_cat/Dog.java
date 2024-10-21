package plymorphism.animal_gog_cat;

public class Dog extends Animal {
    private int height;
    private String voice;

    public Dog(int id, String name, int age, String breed, int height, String voice) {
        super(id, name, age, breed);
        this.height = height;
        this.voice = voice;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public String toString() {
        return super.toString() + "Height: " + height + "\n" + "Voice: " + voice + "\n";
    }

    public String getDayRoutine() {
        return "Morning Walk, Play Time, evening Walk, Dinner, Nap.";

    }

    public void voice() {
        System.out.println("Woof, woof, woof.....");
    }
}
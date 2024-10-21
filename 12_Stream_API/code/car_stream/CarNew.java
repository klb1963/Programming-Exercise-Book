package car_stream;

public class CarNew {
    private String brand;
    private int age;
    private double price;
    private boolean isNew;

    public CarNew(String brand, int age, double price, boolean isNew) {
        this.brand = brand;
        this.age = age;
        this.price = price;
        this.isNew = isNew;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Override
    public String toString() {
        return "CarNew{" +
                "brand='" + brand + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", isNew=" + isNew +
                '}';
    }
}

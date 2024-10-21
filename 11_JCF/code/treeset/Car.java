package treeset;

import java.util.Objects;

public class Car implements Comparable<Car>{

    private String regNumber;
    private String model;
    private int age;
    private double enginePower;
    private int miles;

    public Car(String regNumber, String model, int age, double enginePower, int miles) {
        this.regNumber = regNumber;
        this.model = model;
        this.age = age;
        this.enginePower = enginePower;
        this.miles = miles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(regNumber, car.regNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(regNumber);
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        return "CarNew{" +
                "regNumber='" + regNumber + '\'' +
                ", model='" + model + '\'' +
                ", age=" + age +
                ", enginePower=" + enginePower +
                ", miles=" + miles +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.regNumber.compareTo(o.regNumber);
    }
}

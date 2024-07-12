package buildings;

import java.util.Objects;

public class Building implements Comparable<Building> {

    private int cadasterNum;
    private int floors;
    private String purpose;
    private int age;
    private boolean isGood;
    private String staff;

    public Building(int cadasterNum, int floors, String purpose, int age, boolean isGood, String staff) {
        this.cadasterNum = cadasterNum;
        this.floors = floors;
        this.purpose = purpose;
        this.age = age;
        this.isGood = isGood;
        this.staff = staff;
    }

    public int getCadasterNum() {
        return cadasterNum;
    }

    public void setCadasterNum(int cadasterNum) {
        this.cadasterNum = cadasterNum;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building building)) return false;
        return cadasterNum == building.cadasterNum;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cadasterNum);
    }

    @Override
    public String toString() {
        return "Building{" +
                "cadasterNum=" + cadasterNum +
                ", floors=" + floors +
                ", purpose='" + purpose + '\'' +
                ", age=" + age +
                ", isGood=" + isGood +
                ", staff='" + staff + '\'' +
                '}';
    }

    @Override
    public int compareTo(Building building) {
        return this.age - building.age; // sort by age
    }
}

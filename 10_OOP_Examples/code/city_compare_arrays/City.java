package city_compare_arrays;

import java.util.Objects;

public class City implements Comparable<City>{
    private String name;
    private int age;
    private int population;

    public City(String name, int age, int population) {
        this.name = name;
        this.age = age;
        this.population = population;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", population=").append(population);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return age == city.age && population == city.population && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, population);
    }

    @Override
    public int compareTo(City city) {
        return this.name.compareTo(city.getName());
    }
}

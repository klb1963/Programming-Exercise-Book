package cars_garage.dao;

import cars_garage.model.Car;

import java.util.function.Predicate;

public class GarageImplStream implements Garage {

    private Car[] cars;
    private int size;

    public GarageImplStream(int capacity) {
        cars = new Car[capacity];
        this.size = 0;
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || size == cars.length || findCarByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars[size++] = car;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (regNumber.equals(cars[i].getRegNumber())) {
                Car temp = cars[i];
                cars[i] = cars[--size];
                return temp;
            }

        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {

//        for (int i = 0; i < size; i++) {
//            if (cars[i].getRegNumber().equals(regNumber)) {
//                return cars[i];
//            }
//        }
       return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return findCarsByPredicate(c -> model.equals(c.getModel()));
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return findCarsByPredicate(c -> company.equals(c.getCompany()));
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return findCarsByPredicate(c -> c.getEngine() >= min && c.getEngine() < max);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return findCarsByPredicate(c -> color.equals(c.getColor()));
    }

    @Override
    public int size() {
        return size;
    }

    private Car[] findCarsByPredicate(Predicate<Car> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (predicate.test(cars[i])) {
                res[j++] = cars[i];
            }
        }
        return res;
    }
}

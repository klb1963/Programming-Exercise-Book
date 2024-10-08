package repository;

import domain.Car;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepositoryMap implements CarRepository {

    private final Map<Long, Car> database = new HashMap<>();
    private long currentId;

    public CarRepositoryMap() {
        save(new Car("Volkswagen", new BigDecimal(10_000), 2010));
        save(new Car("Mazda", new BigDecimal(30_000), 2015));
        save(new Car("Honda", new BigDecimal(50_000), 2020));
    }

    @Override
    public Car save(Car car) {
        car.setId(++currentId);
        database.put(currentId, car);
        return car;
    }

    @Override
    public Car getById(Long id) {
        return database.get(id);
    }

    @Override
    public List<Car> getAll() {
        // TODO домашнее задание
        return null;
    }

    @Override
    public Car update(Car car) {
        // TODO домашнее задание (подлежит изменению только цена автомобиля)
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO домашнее задание

    }
}
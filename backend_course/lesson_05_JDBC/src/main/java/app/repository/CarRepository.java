package app.repository;

import app.domain.Car;

import java.util.List;

public interface CarRepository {

    //read
    List<Car> getAll();
    //read
    Car getById(Long id);
    // create
    Car save(Car car);
    //update
    Car updateCar();

    //delete, may be Car or boolean
    void delete(Long id);

}

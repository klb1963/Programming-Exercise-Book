package ait_car_garage.ait.cars.test;

import ait_car_garage.ait.cars.dao.Garage;
import ait_car_garage.ait.cars.dao.GarageImpl;
import ait_car_garage.ait.cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garage;
    Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(5);
        cars = new Car[4];
        cars[0] = new Car("Number1", "Model1", "Company1", 1.5, "Red");
        cars[1] = new Car("Number2", "Model2", "Company1", 2.5, "Green");
        cars[2] = new Car("Number3", "Model3", "Company2", 1.5, "Red");
        cars[3] = new Car("Number4", "Model4", "Company2", 2.0, "Green");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(cars[0]));
        Car car = new Car("Number5", "Model4", "Company2", 2.0, "Green");
        assertTrue(garage.addCar(car));
        car = new Car("Number6", "Model4", "Company2", 2.0, "Green");
        assertFalse(garage.addCar(car));
    }

    @Test
    void removeCar() {
        assertEquals(cars[0], garage.removeCar("Number1"));
        assertNull(garage.removeCar("Number1"));
    }

    @Test
    void findCarByRegNumber() {
        Car car = garage.findCarByRegNumber("Number4");
        assertEquals(cars[3], car);
        assertEquals(cars[3].getColor(), car.getColor());
        assertEquals(cars[3].getEngine(), car.getEngine());
        assertEquals(cars[3], garage.findCarByRegNumber(new String("Number4")));
    }

    @Test
    void findCarsByModel() {
        Car[] expected = { cars[2] };
        Car[] actual = garage.findCarsByModel(new String("Model3"));
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByCompany() {
        Car[] expected = { cars[2], cars[3] };
        Car[] actual = garage.findCarsByCompany("Company2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByEngine() {
        Car[] expected = { cars[1], cars[3] };
        Car[] actual = garage.findCarsByEngine(1.9, 2.6);
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByColor() {
        Car[] expected = { cars[0], cars[2] };
        Car[] actual = garage.findCarsByColor(new String("Red"));
        assertArrayEquals(expected, actual);
        assertArrayEquals(new Car[0], garage.findCarsByColor("Black"));
    }
}
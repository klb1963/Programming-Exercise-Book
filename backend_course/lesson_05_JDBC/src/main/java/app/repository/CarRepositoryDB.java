package app.repository;

import app.domain.Car;

import java.sql.*;
import java.util.List;

import static app.constants.Constants.*;

public class CarRepositoryDB implements CarRepository{

    //private CarRepository repository = new CarRepositoryMap();

    private Connection getConnection(){
        try {
            Class.forName(DB_DRIVER_PATH); // get path

            // http://10.1.2.3:8080/carss?id=3
            // это URI для http-запроса, URI для подключения к БД выглядит аналогично:
            // jdbc:postgresql://localhost:5432/cars_db?user=postgres&password=ppp77777

            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_ADDRESS, DB_NAME, DB_USERNAME, DB_PASSWORD); // make url
            return DriverManager.getConnection(dbUrl); // получаем connection к СУБД
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Car> getAll() {
        try (Connection connection = getConnection()) {
            // TODO домашнее задание
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Car getById(Long id) {
        try (Connection connection = getConnection()) {
            // TODO домашнее задание
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Car save(Car car) {
        try(Connection connection = getConnection()) {
            String query = String.format("INSERT INTO car(brand, price, year) VALUES ('%s', '%s', %d);", car.getBrand(), car.getPrice(), car.getYear());

            Statement statement = connection.createStatement();
            statement.execute(query, Statement.RETURN_GENERATED_KEYS );
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();

            // get id from resultSet
            Long id = resultSet.getLong(1);
            car.setId(id);
            return car;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car updateCar() {
        try (Connection connection = getConnection()) {
            // TODO домашнее задание (изменению подлежит только цена)
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = getConnection()) {
            // TODO домашнее задание (изменению подлежит только цена)
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package repository;

import domain.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarRepositoryHibernate implements CarRepository{

    private final EntityManager entityManager;

    public CarRepositoryHibernate() {
        this.entityManager = new Configuration()
                .configure("hibernate/postgres.cfg.xml")
                .buildSessionFactory()
                .createEntityManager();
    }

    @Override
    public Car save(Car car) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            throw new RuntimeException("Transaction cancelled.");
        }
    }

    @Override
    public Car getById(Long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public List<Car> getAll() {
        // TODO домашнее задание
        return entityManager.createQuery("from Car", Car.class).getResultList();
    }

    @Override
    public Car update(Car car) {
        // TODO домашнее задание (изменению подлежит только цена)
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Car foundCar = entityManager.find(Car.class, car.getId());
            foundCar.setPrice(car.getPrice());
            transaction.commit();
            return foundCar;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        // TODO домашнее задание
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Car foundCar = entityManager.find(Car.class, id);
            entityManager.remove(foundCar);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }
}

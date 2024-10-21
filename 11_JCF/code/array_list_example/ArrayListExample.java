package array_list_example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        Car[] cars = new Car[5];
        cars[0] = new Car("n1", "m4", "c1", 2.0, "green");
        cars[1] = new Car("n2", "m3", "c1", 2.2, "red");
        cars[2] = new Car("n3", "m2", "c1", 1.6, "white");
        cars[3] = new Car("n4", "m1", "c1", 2.5, "blue");
        cars[4] = new Car("n5", "m0", "c1", 3.0, "black");

        for (Car car: cars) {
            carList.add(car);
        }
        System.out.println(carList);

        Comparator<Car> comparatorByEngine = new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return Double.compare(c1.getEngine(), c2.getEngine());
            }
        };

        carList.sort(comparatorByEngine);

        for (Car car: carList ) {
            System.out.println(car);
        }

        double sum = 0;
        for (Car car: carList) {
            sum = car.getEngine();
        }
        double avgEng = sum / carList.size();

    }

}

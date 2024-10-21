package treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetCarExample {

    public static void main(String[] args) {

        Comparator<Car> carComparatorByAge = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        Comparator<Car> carComparatorByMiles = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getMiles() - o2.getMiles();
            }
        };

        // Create TreeSet
        TreeSet<Car> carTreeSet = new TreeSet<>(carComparatorByAge);

        Car[] cars = new Car[5];
        cars[0] = new Car("N4", "Model1", 5, 2.0, 15000);
        cars[1] = new Car("N3", "Model2", 3, 2.5, 25000);
        cars[2] = new Car("N2", "Model1", 2, 3.0, 50000);
        cars[3] = new Car("N1", "Model3", 7, 1.4, 10000);
        cars[4] = new Car("N2", "Model2", 3, 2.5, 25000); // duplicat

        for (Car  car : cars) {
            carTreeSet.add(car);
        }
        // Print TreeSet
        System.out.println(carTreeSet);

        System.out.println("-------------------------------------------");

        // Create another TreeSet
        TreeSet<Car> carTreeSet1 = new TreeSet<>(carComparatorByMiles);
        for (Car car : cars) {
            carTreeSet1.add(car);
        }

        System.out.println(carTreeSet1);

    }
}

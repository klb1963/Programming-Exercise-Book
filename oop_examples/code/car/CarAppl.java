package car;

public class CarAppl {
    public static void main(String[] args) {

        Car[] cars = new Car[5];
        cars[0] = new Car("VW", 10, 15000, false);
        cars[1] = new Car("Mercedes", 5, 55000, false);
        cars[2] = new Car("Opel", 0, 45000, true);
        cars[3] = new Car("VW", 7, 19000, false);
        cars[4] = new Car("BMW", 17, 5000, false);

        for (int i = 0; i < cars.length; i++) {
            if(cars[i].getPrice() < 20000){
                System.out.println(cars[i]);
            }
        }
    }
}

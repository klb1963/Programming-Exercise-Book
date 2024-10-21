package computer_shop;

import computer_shop.model.Computer;
import computer_shop.model.Laptop;
import computer_shop.model.SmartPhone;

public class CmputerShopAppl {
    public static void main(String[] args) {


        Computer computer = new Computer("Core i7", 8, 512, "Asus", 1200);
        Laptop laptop = new Laptop("M2", 16, 1024, "Apple", 3000, 14.1, 2.6, 10);
        System.out.println(computer);
        System.out.println(laptop);

        Computer[] computers = new Computer[7];
        computers[0] = new Computer("Core i7", 8, 512, "Asus", 1200);
        computers[1] = new Computer("Core i5", 4, 512, "Acer", 800);
        computers[2] = new Computer("Core i9", 16, 512, "HP", 1600);
        computers[3] = new Laptop("M2", 16, 1024, "Apple", 3000, 14.1, 2.6, 10); // upper casting
        computers[4] = new Laptop("M1", 8, 512, "Apple", 2400, 12.1, 1.6, 12);
        computers[5] = new Laptop("M3", 32, 2048, "Apple MacBook Pro", 5200, 16, 3.6, 16);
        computers[6] = new SmartPhone("A3", 128, 64, "iPhone 14", 1400, 7.5, 0.6, 20, 16);

        int sumSsd = 0;
        for (int i = 0; i < computers.length; i++) {
            sumSsd += computers[i].getSsd();
        }
        System.out.println("Toatal ssd: " + sumSsd);

        double totalPrice = 0;
        for (int i = 0; i < computers.length; i++) {
            totalPrice += computers[i].getPrice();
        }
        System.out.println("Total amount of money: " + totalPrice);

        System.out.println("====================================");
     // calculate weight
        double totalWeight = 0;

        for (int i = 0; i < computers.length; i++) {
            if (computers[i] instanceof Laptop) { // down casting делается только после проверки instanceof
                Laptop myLaptop = (Laptop) computers[i];
                totalWeight += myLaptop.getWeight();
            }
        }
        System.out.println("Total weight = " + totalWeight);
    }
}

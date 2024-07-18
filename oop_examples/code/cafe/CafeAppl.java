package cafe;

import cafe.controller.Cafe;
import cafe.model.Table;

public class CafeAppl {
    public static void main(String[] args) {

        Cafe myNewCafe = new Cafe(4);
        myNewCafe.printCafeStatus();
        Table table1 = new Table(1, false, 4, 30);
        myNewCafe.addTableInService(table1);
        Table table2 = new Table(2, false, 4, 30);
        myNewCafe.addTableInService(table2);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        System.out.println("-------------- add table to service once again -----------------");
        myNewCafe.addTableInService(table2);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        myNewCafe.addReservation(1);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        System.out.println("--------------пытаемся зарезервировать этот же столик еще раз -----------------");
        myNewCafe.addReservation(1);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        Table table3 = new Table(3, false, 6, 30);
        myNewCafe.addTableInService(table3);
        System.out.println("----------------- add next table to service ----------------");
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        myNewCafe.addReservation(3);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        myNewCafe.addReservation(2);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        myNewCafe.printCafeStatus();
        Table table4 = new Table(4, false, 4, 30);
        myNewCafe.addTableInService(table4);
        Table table5 = new Table(5, false, 4, 30);
        myNewCafe.addTableInService(table5);
        myNewCafe.printCafeStatus();
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        myNewCafe.cancelReservation(1);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        System.out.println("--------- remove reservation once again ----------------");
        myNewCafe.cancelReservation(1);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        System.out.println("==============================================");
        myNewCafe.printCafeStatus();
        System.out.println("==============================================");
        System.out.println("-------------- убираем стол из обслуживания  -----------------");
        Table victim = myNewCafe.removeTableFromService(table3);
        System.out.println(victim);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        System.out.println("-------------- убираем стол из обслуживания  -----------------");
        victim = myNewCafe.removeTableFromService(table1);
        System.out.println(victim);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        myNewCafe.printCafeStatus();
        myNewCafe.cancelReservation(2);
        myNewCafe.cancelReservation(3);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        myNewCafe.removeTableFromService(table2);
        myNewCafe.removeTableFromService(table3);
        myNewCafe.removeTableFromService(table4);
        System.out.println("-------------- столы  -----------------");
        myNewCafe.printTables();
        myNewCafe.printCafeStatus();

    }
}

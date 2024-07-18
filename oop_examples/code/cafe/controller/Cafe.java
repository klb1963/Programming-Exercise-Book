package cafe.controller;

import cafe.model.Table;

public class Cafe {

    final String RESERVED = "is booked.";
    final String FREE = "is free.";

    Table[] tables;
    int numberOfTables;
    int reservedTables;
    int tableInService;

    public Cafe(int capacity) {
        this.tables = new Table[capacity];
        this.numberOfTables = capacity;
        this.reservedTables = 0;
        this.tableInService = 0;
    }

    // print cafe status
    public void printCafeStatus() {
        System.out.println("--------------- Cafe status: ----------------");
        System.out.println("Total tables (cafe capacity): " + tables.length);
        System.out.println("Tables in service: " + tableInService);
        System.out.println("Number of booked tables: " + reservedTables);
        System.out.println("--------------------------------------------");
    }

    // add Table
    public boolean addTableInService(Table table) {
        if (table == null || tableInService == tables.length || findTableInService(table.getId()) != null) {
            System.out.println("Table " + table.getId() + " is already in service or more than capacity.");
            return false;
        }
        // в конец массива добавляем новый элемент
        tables[tableInService] = table; // size - это индекс первого свободного места в массиве
        tableInService++;
        return true;
    }

    // find Table in service
    private Table findTableInService(int id) {
        for (int i = 0; i < tableInService; i++) {
            if (tables[i].getId() == id) {
                return tables[i];
            }
        }
        return null;
    }

    // table reservation
    public boolean addReservation(int id) {
        int index = id - 1;
        if (id > tableInService || tables[index].isReserved()) {
            System.out.println("Table with id: " + id + " is out of service or already booked.");
            return false;
        }
        tables[index].setReserved(true);
        System.out.println("Table " + id + " is booked now.");
        reservedTables++;
        return true;
    }

    // print tables
    public void printTables() {
        int countFree = 0;
        int countBooked = 0;
        for (int i = 0; i < tableInService; i++) {
            System.out.println(tables[i]);
        }
    }

    public boolean cancelReservation(int id) {
        int index = id - 1;
        if (id > tableInService || tables[index].isReserved() == false) {
            System.out.println("Table with id: " + id + " is out of service or table is already FREE.");
            return false;
        }
        tables[index].setReserved(false);
        System.out.println("Table " + id + " is now FREE.");
        reservedTables--;
        return true;
    }

    public Table removeTableFromService(Table table){
        if(table.isReserved()){
            System.out.println("Table is reserved and can't be removed!");
            return table;
        }
        Table victim = null;;
        for (int i = 0; i < tableInService; i++) {
            if(tables[i].getId() == table.getId()){
                victim = tables[i];
                // на место этого стола ставим в массив последний
                tables[i] = tables[tableInService - 1]; // ставим последний на место удаляемого
                tables[tableInService - 1] = null;
                tableInService--;
                break; // останавливаем цикл
            }
        }
        return victim;
    }

}

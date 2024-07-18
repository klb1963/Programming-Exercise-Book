package cafe.model;

import java.util.Objects;

public class Table {

    int id;
    boolean isReserved;
    int numberOfSeats;
    double avgCheck;

    public Table(int id, boolean isReserved, int numberOfSeats, double avgCheck) {
        this.id = id;
        this.isReserved = isReserved;
        this.numberOfSeats = numberOfSeats;
        this.avgCheck = avgCheck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // это getter
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getAvgCheck() {
        return avgCheck;
    }

    public void setAvgCheck(double avgCheck) {
        this.avgCheck = avgCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table table)) return false;
        return id == table.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        String status = "";
        if (isReserved) {
            status = "BOOKED";
        } else {
            status = "FREE";
        }
        return "Table{" +
                " id= " + id +
                ", seats: " + numberOfSeats +
                ", status: " + status +
                '}';

    }
}

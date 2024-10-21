package computer_shop.model;

public class SmartPhone extends Laptop {

    private int cameraResolution;

    public SmartPhone(String cpu, int ram, int ssd, String brand, double price, double displaySize, double weight, int batteryCapacity, int cameraResolution) {
        super(cpu, ram, ssd, brand, price, displaySize, weight, batteryCapacity);
        this.cameraResolution = cameraResolution;
    }


}

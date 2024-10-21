package parcel_post_comparable;

class Parcel implements Comparable<Parcel>{

    // types in Java
    // primitives: char, short, byte, int, long, double, float, boolean
    // String

    // fields
    private int length;
    private int with;
    private int height;
    private double weight;
    private String address;
    private String sender;

    // constructor
    public Parcel(int length, int with, int height, double weight, String address, String sender) {
        this.length = length;
        this.with = with;
        this.height = height;
        this.weight = weight;
        this.address = address;
        this.sender = sender;
    }

    @Override
    public int compareTo(Parcel parcel) {
        return (int) (this.weight - parcel.weight); // sort by weight
    }

    // getters and setters
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWith() {
        return with;
    }

    public void setWith(int with) {
        this.with = with;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "parcel_post.Parcel{" +
                "length=" + length +
                ", with=" + with +
                ", height=" + height +
                ", weight=" + weight +
                ", address='" + address + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }

}

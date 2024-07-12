package river_array;

public class River {

    private String name;
    private String continent;
    private int length;

    public River(String name, String continent, int length) {
        this.name = name;
        this.continent = continent;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "River{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", length=" + length +
                '}';
    }

    public static River minRiver(River[] rivers){
        int minLength = rivers[0].getLength(); // get as min the 1st element of array
        int indexMin = 0;
        for (int i = 0; i < rivers.length; i++) {
            if(rivers[i].getLength() < minLength){
                minLength = rivers[i].getLength();
                indexMin = i;
            }
        }
        return  rivers[indexMin];
    }
}

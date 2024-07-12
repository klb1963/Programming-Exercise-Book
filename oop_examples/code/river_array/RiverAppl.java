package river_array;

public class RiverAppl {
    public static void main(String[] args) {

        River[] rivers = new River[10];

        rivers[0] = new River("Moskva", "Europe", 300);
        rivers[1] = new River("Neva", "Europe", 60);
        rivers[2] = new River("Voga", "Europe", 5000);
        rivers[3] = new River("Amazonka", "South America", 7100);
        rivers[4] = new River("Nile", "Africa", 6500);
        rivers[5] = new River("Missisipy", "North America", 6420);
        rivers[6] = new River("Rein", "Europe", 4000);
        rivers[7] = new River("Ob", "Asia", 5700);
        rivers[8] = new River("Senna", "Europe", 2000);
        rivers[9] = new River("Yukon", "North America", 6210);

        // найдем реку с минимальной длиной
        River minRiver = River.minRiver(rivers);
        int minLength = minRiver.getLength();

        System.out.println("River with min length: " + minLength + ", " + minRiver);

    }


}

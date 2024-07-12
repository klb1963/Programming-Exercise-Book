package buildings;

import java.util.Arrays;
import java.util.Comparator;

public class BuildingAppl {
    public static void main(String[] args) {

        Building b1 = new Building(1, 10, "civil", 10, true, "beton");

        Building[] buildings = new Building[4];
        buildings[0] = new Building(1, 20, "civil", 1, true, "beton");
        buildings[1] = new Building(2, 10, "civil", 5, true, "beton");
        buildings[2] = new Building(3, 5, "civil", 10, true, "beton");
        buildings[3] = new Building(4, 30, "civil", 3, true, "beton");


        // print as is
        System.out.println("================= array as is ====================");
        for (int i = 0; i < buildings.length; i++) {
            System.out.println(buildings[i]);
        }

        // sort array
        Arrays.sort(buildings);

        // print after sorting
        System.out.println("================= array after sorting by age ====================");
        for (int i = 0; i < buildings.length; i++) {
            System.out.println(buildings[i]);
        }

        Comparator<Building> comparatorFloors = new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                return o1.getFloors() - o2.getFloors();
            }
        };

        // sort array by floors
        Arrays.sort(buildings, comparatorFloors);

        System.out.println("================= array after sorting by floor ====================");
        for (int i = 0; i < buildings.length; i++) {
            System.out.println(buildings[i]);
        }

    }
}

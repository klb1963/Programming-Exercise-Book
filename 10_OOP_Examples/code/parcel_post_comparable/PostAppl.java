package parcel_post_comparable;

import java.util.Arrays;
import java.util.Comparator;

public class PostAppl {
    public static void main(String[] args) {

        // create object of type Parcel
        Parcel parcel = new Parcel(10, 20, 5, 3.5, "Address", "Yulia");

        System.out.println(parcel.getHeight());
        System.out.println(parcel.getWeight());
        System.out.println(parcel.getAddress());

        Parcel[] parcels = new Parcel[5];
        parcels[0] = new Parcel(10, 20, 5, 5.0, "Address", "Yulia");
        parcels[1] = new Parcel(20, 20, 5, 3.5, "Address", "Adam");
        parcels[2] = new Parcel(30, 20, 5, 100.1, "Address", "Eva");
        parcels[3] = new Parcel(40, 20, 5, 1.5, "Address", "Zombi");
        parcels[4] = new Parcel(50, 20, 5, 2.5, "Address", "Yulia");

        // print array as is
        for (Parcel p : parcels) {
            System.out.println(p);
        }

        for (int i = 0; i < parcels.length; i++) {
            System.out.println(parcels[i]);
        }

        Arrays.sort(parcels); // sorting
        System.out.println("---------------------------------------");
        // print array after sorting by
        for (Parcel p : parcels) {
            System.out.println(p);
        }

        Comparator<Parcel> comparatorByName = new Comparator<Parcel>() {
            @Override
            public int compare(Parcel o1, Parcel o2) {
                return o1.getSender().compareTo(o2.getSender());
            }
        };

        Arrays.sort(parcels, comparatorByName);
        System.out.println("---------------------------------------");
        // print array after sorting by
        for (Parcel p : parcels) {
            System.out.println(p);
        }

        Arrays.toString(parcels);

    }
}

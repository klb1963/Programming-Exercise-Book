package city_compare_arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    City[] cities;

    @BeforeEach
    void setUp() {

        cities = new City[6];

        cities[0] = new City("Denver", 150, 600_000);
        cities[1] = new City("Boston", 350, 670_000);
        cities[2] = new City("Chicago", 300, 2_700_000);
        cities[3] = new City("Atlanta", 200, 470_000);
        cities[4] = new City("New York", 400, 8_500_000);
        cities[5] = new City("Dallas", 180, 1_300_000);

    }

    @Test
    void printTest(){
        printCities(cities);

    }

    @Test
    void sortByNameTest(){
        Arrays.sort(cities); // sort in memory
        printCities(cities);

    }

    private static void printCities(City[] cities){
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }
    }

}
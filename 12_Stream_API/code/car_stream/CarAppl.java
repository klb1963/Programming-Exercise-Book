package car_stream;

import java.util.ArrayList;
import java.util.List;

public class CarAppl {

    public static void main(String[] args) {

        CarNew[] carNews = new CarNew[6];

        carNews[0] = new CarNew("VW", 20, 12000, false);
        carNews[1] = new CarNew("BMW", 22, 10000, false);
        carNews[2] = new CarNew("Audi", 19, 11000, false);
        carNews[3] = new CarNew("Ford", 21, 13000, false);
        carNews[4] = new CarNew("Volvo", 22, 14000, false);
        carNews[5] = new CarNew("Mercedes", 23, 9000, false);

        List<CarNew> carNewList = new ArrayList<>(); // создали ArrayList
        for (int i = 0; i < carNews.length; i++) {
            carNewList.add(carNews[i]); // положили пользователей в список типа ArrayList
        }

        // Перебор всех элементов userList с помощью forEach() и вывод их в консоль
        // printCars(carNewList);
        // Перебор всех элементов с выполнением некоторой операции над каждым элементом списка и вывод их в консоль.
        // первая буква от бренда
       //  printBrandFirstLetter(carNewList);
        // Сортировка списка по полю age
        //printCarsSortedByAge(carNewList);
        //Сортировка списка по нескольким свойствам: age, firstName, lastName.
        //printCarsSortedByAgeAndBrand(userList);
        // средний возраст
        //calcCarsAvgAge(userList);
        // Проверка, что все авто имеют возраст (age) больше 15
        //isAgeMore15(carNewList, 15);
        // Количество пользователей из разных стран
        // calcBrands(carNewList);

    }




}

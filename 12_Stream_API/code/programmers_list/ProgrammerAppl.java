package programmers_list;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProgrammerAppl {

    public static void main(String[] args) {

        List<Programmer> programmers = fillListProgrammers(); // в объекте programmers внутри имена и названия языков, которые они знают
        // 1. Какие языки вообще знают наши программисты?
        // - вытащить все языки
        // - убрать повторы
        System.out.println("===============  List of Technologies =====================");
        printTechnologies(programmers);
        System.out.println("-------------------------------------------------");

        // 2. Сколько раз встретился язык программирования?
        // - собрать мапу: язык - сколько раз он встретился
        System.out.println("=============== Popular Technologies =====================");
        printTechnologiesByQuantity(programmers);
        System.out.println("-------------------------------------------------");

        // 3. Сортируем языки программирования по популярности
        System.out.println("=============== Technologies sorted =====================");
        printSortedTechnologies(programmers);

        // 4.  нам надо "вытащить" данные из объекта programmers и узнать:
        // кто из программистов знает больше языков
        System.out.println("=============== Most Skilled Programmers =====================");
        printMostSkilledProgrammers(programmers);
        System.out.println("-------------------------------------------------");

        // 5. Рейтинг языков
        System.out.println("=============== Technologies rating =====================");
        printTechnologiesRating(programmers);

    }

    private static void printTechnologies(List<Programmer> programmers) {
        List<String> technologies = programmers.stream()
                .map(Programmer::getTechnology) // взяли списки с языками от каждого программиста
                .flatMap(List::stream) // объединили в один поток
                //  .distinct()
                .toList(); // получили список языков
        System.out.println(technologies);
        System.out.println("----------------------------------------");
        // 2-й способ убрать дубликаты
        StreamSupport.stream(technologies.spliterator(), false)
                .distinct()
                .forEach(System.out::println);
    }

//////////////
    private static void printTechnologiesByQuantity(List<Programmer> programmers) {
        Map<String, Long> technologiesByQuantity = programmers.stream()
                .map(Programmer::getTechnology)  // получаем список технологий каждого программиста
                .flatMap(List::stream)           // объединяем списки в единый поток
                .collect(Collectors.groupingBy(   // группируем по названию технологии
                        technology -> technology,     // ключ - название технологии
                        Collectors.counting()         // считаем количество каждой технологии
                ));
        System.out.println(technologiesByQuantity);
    }
/////////////////

    private static void printSortedTechnologies(List<Programmer> programmers) {
        List<String> technologies = programmers.stream()
                .map(Programmer::getTechnology) // взяли списки с языками от каждого программиста
                .flatMap(List::stream) // объединили в один поток
                .distinct()
                .sorted(String::compareTo)
                .toList();
        technologies.forEach(System.out::println);
    }

    private static void printTechnologiesRating(List<Programmer> programmers) {
        Map<String, Long> technologiesByQuantity = programmers.stream()
                .map(Programmer::getTechnology)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        technology -> technology,     // ключ - название технологии
                        Collectors.counting()         // считаем количество каждой технологии
                ));
        technologiesByQuantity.forEach((key, value)-> System.out.println(key + " : " + value));


////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("=============== Technologies rating =====================");
        // Сортируем по значению в порядке убывания
        Map<String, Long> sortedTechnologiesByQuantity = technologiesByQuantity.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // сортируем по значению в убывающем порядке
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,               // обработка коллизий, хотя они не должны возникнуть
                        LinkedHashMap::new            // используем LinkedHashMap для сохранения порядка
                ));

        sortedTechnologiesByQuantity.forEach((key, value) -> System.out.println(key + " : " + value));

    }


    private static void printMostSkilledProgrammers(List<Programmer> programmers) {
        // надо собрать мапу: кол-во языков -> список программистов
        // ключ - длина списка языков у каждого из программистов,
        Map<Integer, List<Programmer>> skilledProgrammers = programmers.stream()
                .collect(Collectors.groupingBy(p -> p.getTechnology().size()));



        // порядок вывода оказался случайно таким (2, 3, 4), для гарантированной упорядочности нужно указать TreeMap
//        Map<Integer, List<Programmer>> skilledProgrammers = programmers.stream()
//                .collect(Collectors.groupingBy(p -> p.getTechnology().size(), TreeMap::new, Collectors.toList()));

        skilledProgrammers.forEach((key, value)-> System.out.println(key + " : " + value));
        System.out.println("----------------------------------------");
        for (Integer n : skilledProgrammers.keySet()) {
            System.out.println( n + " : " + skilledProgrammers.get(n));
        }
        System.out.println("/////////////////////////////////////////////");
        // ищем max из ключей
        int max = skilledProgrammers.keySet().stream() // берем сет ключей и ищем max с помощью stream()
                .max(Integer::compareTo).orElse(0);

        List<Programmer> champs = programmers.stream()
                .filter(programmer -> programmer.getTechnology().size() == max)
                .toList();
        System.out.println(champs);

    }


    // этот метод заполняет объект первичными данными: имя + список языков
    private static List<Programmer> fillListProgrammers() {
        return List.of(
          new Programmer("Peter", List.of("C++", "Python", "Java", "Kotlin")),
          new Programmer("John", List.of("Python", "Java")),
          new Programmer("Helen", List.of("Kotlin", "Scala", "Java", "JavaScript")),
          new Programmer("Jakob", List.of("Python", "Go")),
          new Programmer("Mike", List.of("Fortran", "Algol", "PL-1"))
        );
    }
}

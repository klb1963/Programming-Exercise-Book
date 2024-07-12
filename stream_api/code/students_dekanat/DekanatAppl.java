package students_dekanat;

import java.util.*;
import java.util.stream.Collectors;

public class DekanatAppl {
    public static void main(String[] args) {
        Student[] studentArray = new Student[10];
        studentArray[0] = new Student( 1, "Alex", "Müller", "19.12.2000", "Mathematics", 1, "Germany", "male" );
        studentArray[1] = new Student( 2, "Anna", "Mayer", "21.11.1999", "Physics", 2, "Germany", "female" );
        studentArray[2] = new Student( 3, "Julia", "Andreeva", "02.04.2001", "Biology", 3, "Russia", "female" );
        studentArray[3] = new Student( 4, "Max", "Schneider", "13.11.2002", "Mathematics", 1, "Austria", "male" );
        studentArray[4] = new Student( 5, "Yaroslav", "Petrenko", "09.12.1998", "Physics", 2, "Ukraine", "male" );
        studentArray[5] = new Student( 6, "Olesia", "Petrenko", "04.10.2002", "Mathematics", 1, "Ukraine", "female" );
        studentArray[6] = new Student( 7, "John", "Smith", "09.06.2003", "Economy", 4, "USA", "male" );
        studentArray[7] = new Student( 8, "Eva", "Johnson", "07.01.2004", "Economy", 4, "USA", "female" );
        studentArray[8] = new Student( 9, "Andrey", "Volkov", "29.11.2002", "Physics", 2, "Russia", "male" );
        studentArray[9] = new Student( 10, "Sophie", "Wagner", "04.02.2001", "Biology", 3, "Austria", "female" );

        // Convert array to list
        List<Student> students = Arrays.asList(studentArray);

        // List of students by course
        Map<String, List<Student>> studentsByCourse = students.stream()
                .collect(Collectors.groupingBy(Student::getCourse));

        // List of students by group
        Map<Integer, List<Student>> studentsByGroup = students.stream()
                .collect(Collectors.groupingBy(Student::getNumGroup));

        // Sorting students by last name
        List<Student> sortedByLastName = new ArrayList<>(students);
        sortedByLastName.sort(Comparator.comparing(Student::getLastName));

        // Sorting students by age
        List<Student> sortedByAge = new ArrayList<>(students);
        sortedByAge.sort(Comparator.comparingDouble(Student::getAge));

        // Number of male students
        long maleCount = students.stream()
                .filter(student -> "male".equalsIgnoreCase(student.getGender()))
                .count();

        // Number of female students
        long femaleCount = students.stream()
                .filter(student -> "female".equalsIgnoreCase(student.getGender()))
                .count();

        // Average age of students for each course
        Map<String, Double> averageAgeByCourse = students.stream()
                .collect(Collectors.groupingBy(Student::getCourse, Collectors.averagingDouble(Student::getAge)));

        // Average age of all students
        double averageAge = students.stream()
                .collect(Collectors.averagingDouble(Student::getAge));

        // Output results
        System.out.println("Students by course:");
        studentsByCourse.forEach((course, studentList) -> {
            System.out.println(course + ": " + studentList);
        });

        System.out.println("\nStudents by group:");
        studentsByGroup.forEach((group, studentList) -> {
            System.out.println(group + ": " + studentList);
        });

        System.out.println("\nStudents sorted by last name:");
        sortedByLastName.forEach(System.out::println);

        System.out.println("\nStudents sorted by age:");
        sortedByAge.forEach(System.out::println);

        System.out.println("\nNumber of male students: " + maleCount);
        System.out.println("Number of female students: " + femaleCount);

        System.out.println("\nAverage age by course:");
        averageAgeByCourse.forEach((course, avgAge) -> {
            System.out.println(course + ": " + avgAge);
        });

        System.out.println("\nAverage age of all students: " + averageAge);
    }
}

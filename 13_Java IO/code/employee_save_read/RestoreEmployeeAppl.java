package employee_save_read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

public class RestoreEmployeeAppl {

    static Set<Employee> employeeSet = new HashSet<>();

    public static void main(String[] args) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"))) {

            employeeSet = (Set<Employee>) ois.readObject();
            // Используем Stream API для вывода каждого сотрудника на новой строке
            employeeSet.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------------------------------");

        double totalSalary = employeeSet.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(totalSalary);

    }
}

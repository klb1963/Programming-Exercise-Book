package company_copy.ait.employee.dao;



import company_copy.ait.employee.model.Employee;
import company_copy.ait.employee.model.SalesManager;

import java.util.Arrays;
import java.util.function.Predicate;

public class CompanyCopyImpl implements Company {
    private Employee[] employees;
    private int size;

    public CompanyCopyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || employees.length == size || findEmployee(employee.getId()) != null) {
            return false;
        }
        employees[size++] = employee;
//        size++;
        return true;
    }

    // use array.copy
    @Override
    public Employee removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                Employee victim = employees[i];
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[--size] = null;
                return victim;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public double totalSalary() {
        double res = 0;
        for (int i = 0; i < size; i++) {
            res += employees[i].calcSalary();
        }
        return res;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public double totalSales() {
        double res = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i] instanceof SalesManager salesManager) {
                res += salesManager.getSalesValue();
            }
        }
        return res;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // refactor with Predicate and lambda
    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        return findEmployeesByPredicate(e -> e.getHours() > hours);
    }

    // refactor with Predicate and lambda
    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
        return findEmployeesByPredicate(e -> e.calcSalary() >= minSalary && e.calcSalary() < maxSalary);
    }

    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
        Employee[] res = new Employee[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(employees[i])) {
                res[j++] = employees[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
}
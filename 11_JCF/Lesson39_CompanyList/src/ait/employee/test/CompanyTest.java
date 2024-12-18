package ait.employee.test;

import ait.employee.dao.Company;
import ait.employee.dao.CompanyCopyImpl;
import ait.employee.dao.CompanyListImpl;
import ait.employee.model.Employee;
import ait.employee.model.Manager;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Company company;
    Employee[] firm;

    @BeforeEach
    void setUp() {
        company = new CompanyListImpl(5);
        firm = new Employee[4];
        firm[0] = new Manager(1000, "John", "Smith", 160, 5000, 5);
        firm[1] = new WageEmployee(2000, "Ann", "Smith", 160, 15);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 160, 19000, 0.1);
        firm[3] = new SalesManager(4000, "Rabindranate", "Agraval", 80, 20000, 0.1);
        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);
        }
    }

    @Test
    void addEmployee() {
        //TODO Homework assert exception if employee is null
        boolean flag;
        try {
            company.addEmployee(null);
            flag = true;
        } catch (RuntimeException e) {
            flag = false;
            assertEquals("null", e.getMessage());
        }
        assertFalse(flag);
        assertFalse(company.addEmployee(firm[1]));
//        assertFalse(company.addEmployee(null));
        Employee employee = new SalesManager(5000, "Peter", "Jackson", 160, 19000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.quantity());
        employee = new SalesManager(6000, "Peter", "Jackson", 160, 19000, 0.1);
        assertFalse(company.addEmployee(employee));
    }

    @org.junit.jupiter.api.Test
    void removeEmployee() {
        Employee employee = company.removeEmployee(3000);
        assertEquals(firm[2], employee);
        assertEquals(3, company.quantity());
        assertNull(company.removeEmployee(3000));
    }

    @org.junit.jupiter.api.Test
    void findEmployee() {
        assertEquals(firm[0], company.findEmployee(1000));
        assertNull(company.findEmployee(5000));
    }

    @org.junit.jupiter.api.Test
    void totalSalary() {
        assertEquals(12280, company.totalSalary(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void quantity() {
        assertEquals(4, company.quantity());
    }

    @org.junit.jupiter.api.Test
    void avgSalary() {
        assertEquals(12280. / 4, company.avgSalary(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void totalSales() {
        assertEquals(39000, company.totalSales(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void printEmployees() {
        company.printEmployees();
    }

    @Test
    void findEmployeesHoursGreaterThan() {
        Employee[] actual = company.findEmployeesHoursGreaterThan(100);
        Employee[] expected = {firm[0], firm[1], firm[2]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findEmployeesSalaryRange() {
        Employee[] actual = company.findEmployeesSalaryRange(2000, 2400);
        Employee[] expected = {firm[2], firm[3]};
        assertArrayEquals(expected, actual);
    }
}
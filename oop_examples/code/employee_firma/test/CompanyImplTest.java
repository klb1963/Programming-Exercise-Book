package employee_firma.test;


import employee_firma.dao.Company;
import employee_firma.dao.CompanyImpl;
import employee_firma.model.Employee;
import employee_firma.model.Manager;
import employee_firma.model.SalesManager;
import employee_firma.model.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CompanyImplTest {

    Company company;
    Employee[] firma;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl(5);
        firma = new Employee[5];

        firma[0] = new Worker(1000, "N1", "L1", 160, 15, 35);
        firma[1] = new Manager(2000, "N1", "L1", 160, 15, 5000, 15);
        firma[2] = new SalesManager(3000, "N1", "L1", 160, 15, 30000, 0.1);
        firma[3] = new SalesManager(4000, "N1", "L1", 160, 15, 35000, 0.1);

        for (int i = 0; i < firma.length; i++) {
            company.addEmployee(firma[i]);
        }
    }

    @Test
    void addEmployee() {
        assertFalse(company.addEmployee(null)); // add null
        assertFalse(company.addEmployee(firma[0])); //try to add duplicate
        Employee employee = new SalesManager(5000, "Mikhael", "Shumaher", 160, 35, 25000, 0.1);
        assertTrue(company.addEmployee(employee)); // add one more
        assertEquals(5, company.quantity()); // check
        employee = new SalesManager(6000, "Nik", "Shumaher", 160, 36, 30000, 0.1);
        assertFalse(company.addEmployee(employee)); // oversize company
    }

    @Test
    void findEmployee() {
        // find
        assertEquals(firma[1], company.findEmployee(2000));
        // find absent
        assertNull(company.findEmployee(5000));
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void revoveEmployee() {
    }

    @Test
    void printEmployee() {
        company.printEmployee();
    }

    @Test
    void quantity() {
    }

    @Test
    void totalSalary() {
    }

    @Test
    void totalSales() {
    }
}
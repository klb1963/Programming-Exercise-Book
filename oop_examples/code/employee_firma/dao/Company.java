package employee_firma.dao;

import employee_firma.model.Employee;

public interface Company {
    /*  C - create
        R - read
        U - update
        D - delete
 */

    // нанимать
    boolean addEmployee(Employee employee);

    // искать
    Employee findEmployee (int id);


    // обновлять данные
    Employee updateEmployee(Employee employee);

    //увольнать удалять
    Employee revoveEmployee(int id);

    //напичать
    void printEmployee();

    //кол - во сотрудников
    int quantity();


    //считать зарплату
    double totalSalary();
    //оборот firma
    double totalSales();



}

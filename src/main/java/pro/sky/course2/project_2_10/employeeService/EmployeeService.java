package pro.sky.course2.project_2_10.employeeService;

import pro.sky.course2.project_2_10.employee.Employee;


import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int office, int salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> allEmployee();
}

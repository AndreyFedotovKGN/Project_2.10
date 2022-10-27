package pro.sky.course2.project_2_10.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.course2.project_2_10.employee.Employee;
import pro.sky.course2.project_2_10.exeption.EmployeeAlreadyAddedException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
    public class EmployeeServiceImpl implements EmployeeService {
        protected final List<Employee> employees;

        private final ValidatorService validatorService;

    public EmployeeServiceImpl(List<Employee> employees, ValidatorService validatorService) {
        this.employees = employees;
        this.validatorService = validatorService;
    }


    @Override
        public Employee addEmployee(String firstName,
                                    String lastName,
                                    int office,
                                    int salary) {
            Employee employee = new Employee(
                    validatorService.validateFirstName(firstName),
                    validatorService.validateLastName(lastName),
                    office,
                    salary);
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.add(employee);
            return employee;
        }

        @Override
        public Employee removeEmployee(String firstName, String lastName) {
            Employee employee = findEmployee(firstName,lastName);
            employees.remove(employee);
            return employee;
        }

        public Employee findEmployee(String firstName, String lastName) {
            final Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findAny();
            return employee.orElseThrow(() -> new RuntimeException());
        }

        @Override
        public Collection<Employee> allEmployee() {
            return Collections.unmodifiableList(employees);
        }


}

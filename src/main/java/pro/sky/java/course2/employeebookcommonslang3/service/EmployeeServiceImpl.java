package pro.sky.java.course2.employeebookcommonslang3.service;

import pro.sky.java.course2.employeebookcommonslang3.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeebookcommonslang3.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebookcommonslang3.exception.InvalidInputException;
import pro.sky.java.course2.employeebookcommonslang3.model.Employee;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, double salary, int departmentId) {

        validateInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.remove(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    private void validateInput(String firstName, String lastName) {
        if(!isAlpha(firstName) || isAlpha(lastName)) {
            throw new InvalidInputException();
        }
    }
}

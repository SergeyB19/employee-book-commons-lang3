package pro.sky.java.course2.employeebookcommonslang3.service;

import com.example.skyprostreamapioptionalhw.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebookcommonslang3.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebookcommonslang3.model.Employee;
import pro.sky.java.course2.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceimpl {
    private final EmployeeService employeeService;

    public DepartmentServiceimpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow((EmployeeNotFoundException::new));
    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findEmployeesFromDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findEmployees() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}

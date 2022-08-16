package pro.sky.java.course2.employeebookcommonslang3.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private final String firstName;

    private final String lastName;
    private double salary;
    private int departmentId;

    public Employee(String firstName, String lastName, double salary, int departmentId) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals((firstName), employee.firstName) && Objects.equals((lastName), employee.lastName);
    }

    @Override
    public int hashCode()    {
        return Objects.hash(firstName, lastName, salary, departmentId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                " ,lastName=" + lastName + '\'' +
                " ,salary=" + salary +
                " ,departmentId=" + departmentId + '}';
    }

}

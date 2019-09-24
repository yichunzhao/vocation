package dk.trifork.vocation.exception;

import dk.trifork.vocation.entities.Employee;

public class EmployeeDuplicatedCreationException extends RuntimeException {

    public EmployeeDuplicatedCreationException(Employee employee) {
        super("Employee id: " + employee.getEmployeeId() + " already existed. ");
    }
}

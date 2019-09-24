package dk.trifork.vocation.exception;


public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String id) {
        super("The employee: " + id + " is not found!");

    }
}

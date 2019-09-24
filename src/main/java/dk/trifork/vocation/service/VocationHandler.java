package dk.trifork.vocation.service;

import dk.trifork.vocation.entities.Employee;
import dk.trifork.vocation.entities.Vocation;

import java.time.Period;
import java.util.Set;

public interface VocationHandler {
    /**
     * an employee creates a vocation, and persisted
     *
     * @param employeeId String
     * @param vocation Vocation
     * @Return Employee
     */
    Employee createEmployeeVocation(String employeeId, Vocation vocation);

    /**
     * fetch all vocations period related with an employee
     *
     * @param employeeId String
     * @return Set<Vocation>
     */
    Set<Vocation> getEmployeeVocations(String employeeId);


    /**
     * with in a specific period, fetch all vocations related with a employee
     *
     * @param employee
     * @param period
     */
    Set<Vocation> getEmployeeVocationPeriod(Employee employee, Period period);


}

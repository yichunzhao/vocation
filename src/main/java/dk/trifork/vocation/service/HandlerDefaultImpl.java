package dk.trifork.vocation.service;

import dk.trifork.vocation.dao.EmployeeRepository;
import dk.trifork.vocation.dao.UserRoleRepository;
import dk.trifork.vocation.dao.VocationRepository;
import dk.trifork.vocation.entities.Employee;
import dk.trifork.vocation.entities.Vocation;
import dk.trifork.vocation.exception.EmployeeDuplicatedCreationException;
import dk.trifork.vocation.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;
import java.util.Set;

@Service
public class HandlerDefaultImpl implements VocationHandler, EmployeeHandler {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private VocationRepository vocationRepository;

    @Override
    public Employee createEmployeeVocation(String employeeId, Vocation vocation) {

        Optional<Employee> eo = employeeRepository.findEmployeeByEmployeeId(employeeId);

        Employee result;

        //if it is an existing employee id,
        if (eo.isPresent()) {
            Employee e = eo.get();
            e.addVocation(vocation);
            result = updateEmployeeByEmployeeId(employeeId, e);

        } else {
            Employee e = new Employee();
            e.setEmployeeId(employeeId);
            e.addVocation(vocation);
            result = createEmployee(e);
        }
        return result;

    }

    @Override
    public Set<Vocation> getEmployeeVocations(String employeeId) {
        return findEmployeeByEmployeeId(employeeId)
                .getVocations();
    }

    @Override
    public Set<Vocation> getEmployeeVocationPeriod(Employee employee, Period period) {
        return null;
    }

    private Employee findEmployeeByEmployeeId(String id) {
        return employeeRepository.findEmployeeByEmployeeId(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    private Employee updateEmployeeByEmployeeId(String id, Employee employee) {
        findEmployeeByEmployeeId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee createEmployee(Employee e) {
        Optional<Employee> found = employeeRepository.findEmployeeByEmployeeId(e.getEmployeeId());
        if (found.isPresent()) {
            throw new EmployeeDuplicatedCreationException(e);
        } else {
            return employeeRepository.save(e);
        }
    }

}

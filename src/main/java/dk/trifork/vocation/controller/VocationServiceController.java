package dk.trifork.vocation.controller;

import dk.trifork.vocation.entities.Employee;
import dk.trifork.vocation.entities.Vocation;
import dk.trifork.vocation.service.VocationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class VocationServiceController {

    @Autowired
    private VocationHandler vocationHandler;

    @PostMapping(value = "/{employeeId}/vocation")
    public ResponseEntity<Employee> createEmployeeVocation(@PathVariable("employeeId") String employeeId, @RequestBody Vocation vocation) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.addVocation(vocation);

        vocationHandler.createEmployeeVocation(employeeId, vocation);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(value = "/{employeeId}/vocations")
    public ResponseEntity<Set<Vocation>> getEmployeeVocations(@PathVariable("employeeId") String employeeId) {
        Set<Vocation> employees = vocationHandler.getEmployeeVocations(employeeId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/hello")
    public String getHello(){
        return "hello world";
    }


    //find an employee by its id, and then modify its vocation status from pending to approved. x




}

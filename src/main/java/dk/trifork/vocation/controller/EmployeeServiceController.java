package dk.trifork.vocation.controller;

import dk.trifork.vocation.entities.Employee;
import dk.trifork.vocation.service.EmployeeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeServiceController {

    @Autowired
    private EmployeeHandler employeeHandler;

    @PostMapping(value = "/employee")
    public ResponseEntity<?> createEmployee(@RequestBody  Employee employee){
        Employee created = employeeHandler.createEmployee(employee);
        return  new ResponseEntity<>(created, HttpStatus.OK);
    };

}

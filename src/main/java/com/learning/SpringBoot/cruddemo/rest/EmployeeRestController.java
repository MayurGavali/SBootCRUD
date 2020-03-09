package com.learning.SpringBoot.cruddemo.rest;


import com.learning.SpringBoot.cruddemo.entity.Employee;
import com.learning.SpringBoot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //inject the employee doa
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose the employee end point which will return all th employee
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/HelloWorld")
    public String WelcomePageTest() {
        return "Welcome to the CRUD Demo";
    }

    /////add maqpping for get / employee/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee id not found");
        }
        return  theEmployee;
}
    // add mapping for POST /Employee- add  new Employee

    @PostMapping("/employees/{employeeId}")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just in case they pass an id in JSON ....SET ID TO 0
        theEmployee.setId(1);
        //This is to force a save of new item ..instead of update
        employeeService.save(theEmployee);
        return theEmployee;

    }
    //add mapping for PUT /Employee - update existing  employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee=employeeService.findById(employeeId);
        //throw an exception if null occurs
        if(tempEmployee==null){
            throw new RuntimeException("Employee id noty found " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "deleted employee is -"+ employeeId;
    }


}

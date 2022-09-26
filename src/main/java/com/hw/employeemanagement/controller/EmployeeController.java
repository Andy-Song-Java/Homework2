package com.hw.employeemanagement.controller;

import com.hw.employeemanagement.model.Employee;
import com.hw.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/get/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
    @GetMapping(value="/all")
    public List<Employee> getEmployees(){
        return service.getAllEmployees();
    }
    @GetMapping(value="/filter/{salary}")
    public List<String> filerBySalary(@PathVariable double salary){
        return service.filterBySalary(salary);
    }
    @PutMapping(value = "/update/{id}")
    public void updateEmployee(@RequestBody Employee temp){
        service.updateEmployee(temp);
    }
    @PostMapping("/new")
    public void addEmployee(@RequestBody Employee temp){
        service.newEmployee(temp);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable int id){
        service.deleteEmployeeById(id);
    }

    public EmployeeService getService() {
        return service;
    }


}

package com.hw.employeemanagement.controller;

import com.hw.employeemanagement.model.Department;
import com.hw.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping(value = "/get/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return service.getDepartmentById(id);
    }
    @GetMapping(value="/all")
    public List<Department> getDepartments(){
        return service.getAllDepartments();
    }

    @PostMapping("/new")
    public void updateDepartment(@RequestBody Department temp){
        service.newDepartment(temp);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteDepartmentById(@PathVariable int id){
        service.deleteDepartmentById(id);
    }

    public DepartmentService getService() {
        return service;
    }


}

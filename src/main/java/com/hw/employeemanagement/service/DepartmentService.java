package com.hw.employeemanagement.service;

import com.hw.employeemanagement.model.Department;
import com.hw.employeemanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepository repo;

    //Get
    public Department getDepartmentById(int id) {
        return repo.findById(id).orElse(null);
    }
    public List<Department> getAllDepartments(){
        return repo.findAll();
    }

    //Put
    public void updateDepartment(Department department) {
        Department existingProduct = repo.findById(department.getDeptid()).orElse(null);
        existingProduct.setName(department.getName());
        existingProduct.setLoc(department.getLoc());
    }

    //Post
    public void newDepartment(Department department) {
        repo.save(department);
    }

    //Delete
    public void deleteDepartmentById(int id) {
        repo.deleteById(id);
    }
    public void deleteAllDepartment(){
        repo.deleteAll();
    }
}

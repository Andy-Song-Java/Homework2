package com.hw.employeemanagement.service;

import com.hw.employeemanagement.helper.EmployeeHelper;
import com.hw.employeemanagement.model.Employee;
import com.hw.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repo;


    @Autowired
    EmployeeHelper helper;

    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElse(null);
    }
    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }
    public void updateEmployee(Employee employee) {
        Employee existingProduct = repo.findById(employee.getEmpid()).orElse(null);
        existingProduct.setName(employee.getName());
    }

    public void newEmployee(Employee temp) {
        repo.save(temp);
    }
    public void deleteEmployeeById(int id) {
        repo.deleteById(id);
    }
    public void deleteAllEmployee(){
        repo.deleteAll();
    }

    public List<String> filterBySalary(double salary){
        return helper.filerBySalary(salary);
    }
}

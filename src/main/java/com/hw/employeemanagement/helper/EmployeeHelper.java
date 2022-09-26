package com.hw.employeemanagement.helper;


import com.hw.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class EmployeeHelper {

    //Customized SQL
    @Autowired
    EmployeeRepository repo;

    public List<String> filerBySalary(double salary){
        return repo.findAllSalary(salary);
    }

}

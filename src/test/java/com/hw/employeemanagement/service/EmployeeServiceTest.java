package com.hw.employeemanagement.service;

import com.hw.employeemanagement.model.Employee;
import com.hw.employeemanagement.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

    @MockBean
    EmployeeRepository repo;

    @Autowired
    EmployeeService service;

    int id = 1;
    Employee mockEmployee = new Employee(1,"Andy", "HR", "Steven", "01/01/2022", 100.00, 1);
    Employee mockEmployee2 = new Employee(2,"Andy2", "HR2", "Steven2", "01/01/20222", 102.00, 2);

    List<Employee> mockEmployeeList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        System.out.println("Unit test on EmployeeService : Starts");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Unit test on EmployeeService : Completed");
    }

    @Test
    void getEmployeeById() {

        Mockito.when(repo.findById(id)).thenReturn(Optional.ofNullable(mockEmployee));
        Employee employee = service.getEmployeeById(id);
        Assert.assertEquals("Andy", employee.getName());
        Assert.assertEquals("HR", employee.getJob());
        Assert.assertEquals("Steven", employee.getManager());
        Assert.assertEquals("01/01/2022", employee.getHiredate());
        Assert.assertEquals(1, employee.getDeptid());
        Assert.assertEquals(100, employee.getSalary(),0.00001);
    }

    @Test
    void getAllEmployees() {
        mockEmployeeList.add(mockEmployee);
        mockEmployeeList.add(mockEmployee2);
        Mockito.when(repo.findAll()).thenReturn(mockEmployeeList);
        List<Employee> employeeList = service.getAllEmployees();
        Assert.assertEquals(2, employeeList.size());

    }

    @Test
    void updateEmployee() {
        Employee mockEmployee3 = new Employee(1,"Andy3", "HR2", "Steven2", "01/01/20222", 102.00, 2);
        Mockito.when(repo.findById(id)).thenReturn(Optional.of(mockEmployee3));

        Assert.assertEquals("Andy3", repo.findById(id).get().getName());

    }

    @Test
    void newEmployee() {
        Mockito.when(repo.save(mockEmployee)).thenReturn(mockEmployee);
        //Employee employee = repo.findById(mockEmployee.getEmpid()).get();
        Assert.assertEquals("Andy", mockEmployee.getName());
    }

    @Test
    void deleteEmployeeById() {
    }

    @Test
    void deleteAllEmployee() {
    }

    @Test
    void filterBySalary() {
    }
}
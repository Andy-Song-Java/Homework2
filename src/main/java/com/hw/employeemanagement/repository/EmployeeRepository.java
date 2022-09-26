package com.hw.employeemanagement.repository;

import com.hw.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.hw.employeemanagement.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //inner join employee on department.deptid = employee.deptid having sum(employee.salary)
    @Query(value = "SELECT name FROM employee WHERE salary > :salary", nativeQuery = true)
    public List<String> findAllSalary(@Param("salary") double salary);
}

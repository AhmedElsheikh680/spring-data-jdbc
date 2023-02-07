package com.spring.repo;

import com.spring.model.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {

    public List<Employee> findByName(String name);

//    public List<Employee> findByNameAndSalary(String name, String salary);

    public List<Employee> findByNameStartingWithAndSalary(String name, String salary);

    public List<Employee> findByNameContainingAndSalaryGreaterThanEqual(String name, String salary);

    @Query(value = "select id, name, salary from employees where name" +" like :empName and salary >= :empSalary")
    public List<Employee> findByNameAndSalary(@Param("empName") String name, @Param("empSalary") String salary);
}

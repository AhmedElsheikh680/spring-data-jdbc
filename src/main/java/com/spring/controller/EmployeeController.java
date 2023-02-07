package com.spring.controller;


import com.spring.model.Employee;
import com.spring.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/{id}")
    public ResponseEntity<?> findEmpById(@PathVariable Long id){
        return ResponseEntity.ok(employeeRepo.findById(id));
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<List<Employee>> findEmpByName(@PathVariable String name){
        return ResponseEntity.ok(employeeRepo.findByName(name));
    }

//    @GetMapping("/filter/{name}/{salary}")
//    public ResponseEntity<List<Employee>> findEmpByNameAndSalary(@PathVariable String name, @PathVariable String salary){
//        return ResponseEntity.ok(employeeRepo.findByNameAndSalary(name, salary));
//    }

//    @GetMapping("/filter/{name}/{salary}")
//    public ResponseEntity<List<Employee>> findEmpByNameStartingWithAndSalary(@PathVariable String name, @PathVariable String salary){
//        return ResponseEntity.ok(employeeRepo.findByNameStartingWithAndSalary(name, salary));
//    }

    @GetMapping("/filter/{name}/{salary}")
    public ResponseEntity<List<Employee>> findEmpByNameContainingAndSalaryGreaterThanEqual(@PathVariable String name, @PathVariable String salary) {
        return ResponseEntity.ok(employeeRepo.findByNameContainingAndSalaryGreaterThanEqual(name, salary));
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Employee>> findAllEmps(){
        return ResponseEntity.ok(employeeRepo.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> addEmp(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepo.save(employee));
    }

    @PutMapping("")
    public ResponseEntity<?> updateEmp(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepo.save(employee));
    }

    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable Long id){
         employeeRepo.deleteById(id);
    }
}

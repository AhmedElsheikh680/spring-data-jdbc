package com.spring.controller;


import com.spring.model.Employee;
import com.spring.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/{id}")
    public ResponseEntity<?> findEmpById(@PathVariable long id){
        return ResponseEntity.ok(employeeRepo.findById(id));
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

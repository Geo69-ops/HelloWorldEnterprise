package com.hwe.helloworldenterprise.controller;

import com.hwe.helloworldenterprise.entity.Employee;
import com.hwe.helloworldenterprise.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employee));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            if(employeeService.findById(id) != null){
                employeeService.delete(id);
                return ResponseEntity.status(HttpStatus.OK).build();
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @GetMapping ("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            if(employeeService.findById(id) != null){

                return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}

package com.hwe.helloworldenterprise.controller;

import com.hwe.helloworldenterprise.entity.Enterprise;
import com.hwe.helloworldenterprise.service.IEntepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {

    @Autowired
    private IEntepriseService entepriseService;

    @PostMapping
    public ResponseEntity<Enterprise> save(@RequestBody Enterprise enterprise) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(entepriseService.save(enterprise));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Enterprise>> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(entepriseService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            if(entepriseService.findById(id) != null){
                entepriseService.delete(id);
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
            if(entepriseService.findById(id) != null){

                return ResponseEntity.status(HttpStatus.OK).body(entepriseService.findById(id));
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}

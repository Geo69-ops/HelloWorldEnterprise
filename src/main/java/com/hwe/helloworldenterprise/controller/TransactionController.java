package com.hwe.helloworldenterprise.controller;


import com.hwe.helloworldenterprise.entity.Transaction;
import com.hwe.helloworldenterprise.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(transactionService.save(transaction));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(transactionService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            if(transactionService.findById(id) != null){
                transactionService.delete(id);
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
            if(transactionService.findById(id) != null){

                return ResponseEntity.status(HttpStatus.OK).body(transactionService.findById(id));
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


}

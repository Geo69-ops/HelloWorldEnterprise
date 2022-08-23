package com.hwe.helloworldenterprise.service.impl;

import com.hwe.helloworldenterprise.entity.Transaction;
import com.hwe.helloworldenterprise.repository.ITransactionDAO;
import com.hwe.helloworldenterprise.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private ITransactionDAO transactionDAO;

    @Override
    public boolean delete(Long id) {
        try {
            transactionDAO.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionDAO.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionDAO.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return transactionDAO.findById(id).get();
    }
}

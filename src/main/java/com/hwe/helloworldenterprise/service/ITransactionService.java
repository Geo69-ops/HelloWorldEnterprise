package com.hwe.helloworldenterprise.service;


import com.hwe.helloworldenterprise.entity.Transaction;

import java.util.List;

public interface ITransactionService  {

    //crud
    public boolean delete(Long id);

    public Transaction save(Transaction transaction);

    public List<Transaction> findAll();

    public Transaction findById(Long id);


}

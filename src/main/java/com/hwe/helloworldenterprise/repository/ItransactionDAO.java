package com.hwe.helloworldenterprise.repository;

import com.hwe.helloworldenterprise.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItransactionDAO extends JpaRepository <Transaction, Long> {
}

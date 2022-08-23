package com.ewallet.api.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.ewallet.api.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("select transaction from Transaction transaction where transaction.wallet.id = :walletId order by transaction.time desc")
	List<Transaction> findAllforWallet(@Param("walletId") Long walletId);


}

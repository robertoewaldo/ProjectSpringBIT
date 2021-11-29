package com.bit.spring.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bit.spring.project.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
	
	@Query(
			value = "select * from transactions\r\n"
					+ "where to_char(transaction_date, 'MM') = to_char(current_date, 'MM')\r\n"
					+ "order by transaction_date desc", 
			nativeQuery = true)
	List<Transaction> findAllTransactionThisMonth();
	
	@Query(
			value = "select * from transactions\r\n"
					+ "	where to_char(transaction_date, 'MM') = to_char(current_date - interval '1 month', 'MM')\r\n"
					+ "	order by transaction_date desc", 
			nativeQuery = true)
	List<Transaction> findAllTransactionLastMonth();
}

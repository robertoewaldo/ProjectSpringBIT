package com.bit.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bit.spring.project.entity.Bill;

public interface BillRepo extends JpaRepository<Bill, Integer>{
	
	@Query(
			value = "select * from bills\r\n"
					+ "where \r\n"
					+ "cast(month as varchar) = to_char(current_date - interval '1 month', 'MM')\r\n"
					+ "and\r\n"
					+ "cast(year as varchar) = to_char(current_date - interval '1 month', 'yyyy')",
			nativeQuery = true)
	public Bill findLastMonthBill();
	
	@Query(
			value = "select * from bills\r\n"
					+ "where \r\n"
					+ "cast(month as varchar) = to_char(current_date, 'MM')\r\n"
					+ "and\r\n"
					+ "cast(year as varchar) = to_char(current_date, 'yyyy')",
			nativeQuery = true)
	public Bill findThisMonthBill();
}

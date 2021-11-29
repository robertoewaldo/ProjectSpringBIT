package com.bit.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.spring.project.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}

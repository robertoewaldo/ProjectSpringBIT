package com.bit.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.spring.project.entity.Purchase;

public interface PurchaseRepo extends JpaRepository<Purchase, Integer> {

}

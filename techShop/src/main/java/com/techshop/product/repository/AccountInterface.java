package com.techshop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techshop.product.entity.Account;

public interface AccountInterface  extends JpaRepository<Account, Long>{

}

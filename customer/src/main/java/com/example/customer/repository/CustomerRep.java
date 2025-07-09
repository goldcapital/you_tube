package com.example.customer.repository;

import com.example.customer.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRep extends JpaRepository<ProfileEntity,Integer> {
}

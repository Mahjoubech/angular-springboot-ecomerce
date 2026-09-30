package com.example.backend.repository;

import com.example.backend.model.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller , String> {
}

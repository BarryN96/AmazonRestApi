package com.example.restapi.repository;


import com.example.restapi.entity.OrderPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPositionRepository extends JpaRepository<OrderPosition,Long> {
}

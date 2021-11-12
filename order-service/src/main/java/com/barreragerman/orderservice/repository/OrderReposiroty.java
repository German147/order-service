package com.barreragerman.orderservice.repository;

import com.barreragerman.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReposiroty extends JpaRepository<Order, Integer> {

}

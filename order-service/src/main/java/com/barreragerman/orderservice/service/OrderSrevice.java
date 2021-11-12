package com.barreragerman.orderservice.service;

import com.barreragerman.orderservice.entity.Order;
import com.barreragerman.orderservice.repository.OrderReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderSrevice {

    @Autowired
    private OrderReposiroty orderReposiroty;

    public Order saveOrder(Order order){
        return orderReposiroty.save(order);
    }
}

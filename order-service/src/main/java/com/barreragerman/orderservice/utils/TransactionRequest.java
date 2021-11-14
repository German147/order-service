package com.barreragerman.orderservice.utils;

import com.barreragerman.orderservice.entity.Order;
import com.barreragerman.orderservice.utils.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionRequest {

    private Order order;
    private Payment payment;
}

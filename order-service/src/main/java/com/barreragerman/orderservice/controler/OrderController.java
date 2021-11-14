package com.barreragerman.orderservice.controler;

import com.barreragerman.orderservice.entity.Order;
import com.barreragerman.orderservice.service.OrderSrevice;
import com.barreragerman.orderservice.utils.Payment;
import com.barreragerman.orderservice.utils.TransactionRequest;
import com.barreragerman.orderservice.utils.TransactionalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderSrevice orderSrevice;

    @PostMapping("/bookOrder")
    public TransactionalResponse  bookOrder(@RequestBody TransactionRequest request){

        return orderSrevice.saveOrder(request);
    }



}

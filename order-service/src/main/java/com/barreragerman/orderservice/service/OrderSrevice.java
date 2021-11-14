package com.barreragerman.orderservice.service;

import com.barreragerman.orderservice.entity.Order;
import com.barreragerman.orderservice.repository.OrderReposiroty;
import com.barreragerman.orderservice.utils.Payment;
import com.barreragerman.orderservice.utils.TransactionRequest;
import com.barreragerman.orderservice.utils.TransactionalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderSrevice {

    @Autowired
    private RestTemplate template;
    @Autowired
    private OrderReposiroty orderReposiroty;

    public TransactionalResponse saveOrder(TransactionRequest request){

        String response="";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call

        Payment paymentResponse = template.postForObject("http://localhost:9191/payment/doPayment",payment,Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success")?"Payment processing successful and order placed":"There is a failure in payment order to cart";

        orderReposiroty.save(order);
        return new TransactionalResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}

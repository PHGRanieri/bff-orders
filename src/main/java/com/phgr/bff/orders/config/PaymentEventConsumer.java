package com.phgr.bff.orders.config;

import com.phgr.bff.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentEventConsumer {

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "payment-events", groupId = "order-group")
    public void consumePaymentEvent(String message) {
        System.out.println("Received Payment Event: " + message);

        // Simples, vamos supor que a mensagem é "orderId:status"
        String[] parts = message.split(":");
        Long orderId = Long.parseLong(parts[0]);
        String status = parts[1];

        orderService.updateOrderStatus(orderId, status);
    }
}
package com.phgr.bff.orders.config;

import com.phgr.bff.orders.domain.PaymentEvent;
import com.phgr.bff.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventListener {

    @Autowired
    private OrderService orderService; // ou OrderRepository se for direto

    @KafkaListener(topics = "${topics.payment}", groupId = "order-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumePaymentEvent(PaymentEvent event) {
        System.out.println("Recebido evento de pagamento: " + event);
        orderService.updateOrderStatus(event.getOrderId(), event.getStatus());
    }
}
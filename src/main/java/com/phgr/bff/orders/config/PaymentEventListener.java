package com.phgr.bff.orders.config;

import com.phgr.bff.orders.domain.PaymentEvent;
import com.phgr.bff.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentEventListener {

    private final OrderService orderService;

    @KafkaListener(topics = "${topics.payment}", groupId = "order-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumePaymentEvent(PaymentEvent event) {
        System.out.println("Recebido evento de pagamento: " + event);
        orderService.updateOrderStatus(event.getOrderId(), event.getStatus());
    }
}
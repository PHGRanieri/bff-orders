package com.phgr.bff.orders.service;

import com.phgr.bff.orders.domain.Order;
import com.phgr.bff.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Order createOrder(Order order) {
        order.setStatus("PENDING");
        return repository.save(order);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public void updateOrderStatus(Long orderId, String status) {
        Order order = repository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        repository.save(order);
    }

}

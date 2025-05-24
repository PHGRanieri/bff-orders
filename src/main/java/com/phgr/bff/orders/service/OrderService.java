package com.phgr.bff.orders.service;

import com.phgr.bff.orders.domain.dto.OrderDto;
import com.phgr.bff.orders.domain.entity.Order;
import com.phgr.bff.orders.domain.enums.PaymentStatusEnum;
import com.phgr.bff.orders.domain.mapper.OrderMapper;
import com.phgr.bff.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    public OrderDto createOrder(Order order) {
        order.setStatus(PaymentStatusEnum.PENDING);
        return mapper.entityToDto(repository.save(order));
    }

    public List<OrderDto> getAllOrders() {
        return mapper.entityToDtoList(repository.findAll()) ;
    }

    public void updateOrderStatus(Long orderId, PaymentStatusEnum status) {
        Order order = repository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        repository.save(order);
    }

}

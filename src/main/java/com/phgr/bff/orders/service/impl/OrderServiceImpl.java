package com.phgr.bff.orders.service.impl;

import com.phgr.bff.orders.domain.dto.OrderDto;
import com.phgr.bff.orders.domain.entity.Order;
import com.phgr.bff.orders.domain.enums.PaymentStatusEnum;
import com.phgr.bff.orders.domain.exception.OrderNotFoundException;
import com.phgr.bff.orders.domain.mapper.OrderMapper;
import com.phgr.bff.orders.repository.OrderRepository;
import com.phgr.bff.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Override
    public OrderDto createOrder(Order order) {
        order.setStatus(PaymentStatusEnum.PENDING);
        return mapper.entityToDto(repository.save(order));
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return mapper.entityToDtoList(repository.findAll()) ;
    }

    @Override
    public void updateOrderStatus(Long orderId, PaymentStatusEnum status) {
        Order order = repository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        order.setStatus(status);
        repository.save(order);
    }

}

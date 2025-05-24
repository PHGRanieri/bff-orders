package com.phgr.bff.orders.service;

import com.phgr.bff.orders.domain.dto.OrderDto;
import com.phgr.bff.orders.domain.entity.Order;
import com.phgr.bff.orders.domain.enums.PaymentStatusEnum;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(Order order);

    List<OrderDto> getAllOrders();

    void updateOrderStatus(Long orderId, PaymentStatusEnum status);

}

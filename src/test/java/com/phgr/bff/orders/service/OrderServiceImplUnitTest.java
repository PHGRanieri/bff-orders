package com.phgr.bff.orders.service;

import com.phgr.bff.orders.domain.dto.OrderDto;
import com.phgr.bff.orders.domain.entity.Order;
import com.phgr.bff.orders.domain.enums.PaymentStatusEnum;
import com.phgr.bff.orders.domain.mapper.OrderMapper;
import com.phgr.bff.orders.repository.OrderRepository;
import com.phgr.bff.orders.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.phgr.bff.orders.domain.OrderMother.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplUnitTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository repository;

    @Mock
    private OrderMapper mapper;

    @Test
    void shouldReturnAllOrdersWithSucess(){
        when(repository.findAll()).thenReturn(List.of(orderPaid()));
        when(mapper.entityToDtoList(List.of(orderPaid()))).thenReturn(List.of(orderDtoPaid()));

        final List<OrderDto> result = orderService.getAllOrders();

        verify(repository, only()).findAll();
        verify(mapper, only()).entityToDtoList(List.of(orderPaid()));
        assertEquals(result, List.of(orderDtoPaid()));
    }

    @Test
    void shouldCreateOrderWithSucess(){
        when(repository.save(orderPending())).thenReturn(orderPending());
        when(mapper.entityToDto(orderPending())).thenReturn(orderDtoPending());

        final OrderDto result = orderService.createOrder(orderRequest());

        verify(repository, only()).save(orderPending());
        verify(mapper, only()).entityToDto(orderPending());
        assertEquals(result, orderDtoPending());
    }

    @Test
    void shouldUpdateOrderWithSucess(){
        when(repository.findById(orderPending().getId())).thenReturn(Optional.of(orderPending()));
        when(repository.save(orderPaid())).thenReturn(orderPaid());

        orderService.updateOrderStatus(1L,PaymentStatusEnum.PAID);

        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);

        verify(repository, times(1)).findById(orderPending().getId());
        verify(repository, times(1)).save(orderCaptor.capture());

        Order savedOrder = orderCaptor.getValue();
        assertNotNull(savedOrder);
        assertEquals(1L, savedOrder.getId());
        assertEquals(PaymentStatusEnum.PAID, savedOrder.getStatus());
    }

}

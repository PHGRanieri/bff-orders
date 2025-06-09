package com.phgr.bff.orders.domain;

import com.phgr.bff.orders.domain.dto.OrderDto;
import com.phgr.bff.orders.domain.entity.Order;
import com.phgr.bff.orders.domain.enums.PaymentStatusEnum;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderMother {

    public static Order orderRequest(){
        return Order.builder()
                .id(1L)
                .price(100.0)
                .product("Product")
                .quantity(1)
                .build();

    }

    public static Order orderPending(){
        return Order.builder()
                .id(1L)
                .price(100.0)
                .product("Product")
                .quantity(1)
                .status(PaymentStatusEnum.PENDING)
                .build();

    }

    public static Order orderPaid(){
        return Order.builder()
                .id(1L)
                .price(100.0)
                .product("Product")
                .quantity(1)
                .status(PaymentStatusEnum.PAID)
                .build();

    }

    public static OrderDto orderDtoPending(){
        return OrderDto.builder()
                .id(1L)
                .price(100.0)
                .product("Product")
                .quantity(1)
                .status(PaymentStatusEnum.PENDING)
                .build();

    }

    public static OrderDto orderDtoPaid(){
        return OrderDto.builder()
                .id(1L)
                .price(100.0)
                .product("Product")
                .quantity(1)
                .status(PaymentStatusEnum.PAID)
                .build();

    }

}

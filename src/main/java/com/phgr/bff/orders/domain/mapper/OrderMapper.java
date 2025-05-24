package com.phgr.bff.orders.domain.mapper;

import com.phgr.bff.orders.domain.dto.OrderDto;
import com.phgr.bff.orders.domain.entity.Order;
import com.phgr.bff.orders.domain.response.OrderResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto entityToDto(Order order);

    List<OrderDto> entityToDtoList(List<Order> orderList);

    OrderResponse dtoToResponse(OrderDto dto);

    List<OrderResponse> dtoToResponseList(List<OrderDto> dtoList);

}

package com.phgr.bff.orders.endpoint;

import com.phgr.bff.orders.domain.entity.Order;
import com.phgr.bff.orders.domain.mapper.OrderMapper;
import com.phgr.bff.orders.domain.response.OrderResponse;
import com.phgr.bff.orders.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    private final OrderMapper mapper;

    @PostMapping
    @Operation(description = "Registra um novo pedido")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(mapper.dtoToResponse(service.createOrder(order)));
    }

    @GetMapping
    @Operation(description = "Recupera lista de pedidos registrados")
    public ResponseEntity<List<OrderResponse>> getOrders() {
        return ResponseEntity.ok(mapper.dtoToResponseList(service.getAllOrders()));
    }

}

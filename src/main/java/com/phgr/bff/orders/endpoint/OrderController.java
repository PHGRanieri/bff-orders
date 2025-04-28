package com.phgr.bff.orders.endpoint;

import com.phgr.bff.orders.domain.Order;
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

    @PostMapping
    @Operation(description = "Registra um novo pedido")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(service.createOrder(order));
    }

    @GetMapping
    @Operation(description = "Recupera lista de pedidos registrados")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(service.getAllOrders());
    }

}

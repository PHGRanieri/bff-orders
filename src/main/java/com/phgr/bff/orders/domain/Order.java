package com.phgr.bff.orders.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Id", description = "Auto-generated order identifier")
    private Long id;

    @Schema(name = "Product", description = "Product name")
    private String product;

    @Schema(name = "Quantity", description = "Quantity of product to be ordered")
    private Integer quantity;

    @Schema(name = "Price", description = "Product price per unit")
    private Double price;

    @Schema(name = "Status", description = "Order payment status")
    private String status;
}


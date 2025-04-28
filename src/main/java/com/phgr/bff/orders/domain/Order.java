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
    @Schema(name = "Id", description = "Identificador de pedido gerado automaticamente")
    private Long id;

    @Schema(name = "Product", description = "Nome do produto")
    private String product;

    @Schema(name = "Quantity", description = "Quantidade de produtos do pedido")
    private Integer quantity;

    @Schema(name = "Price", description = "Preço do produto por unidade")
    private Double price;

    @Schema(name = "Status", description = "Status de pagamento do pedido")
    private String status;
}


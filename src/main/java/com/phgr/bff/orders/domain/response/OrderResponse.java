package com.phgr.bff.orders.domain.response;

import com.phgr.bff.orders.domain.enums.PaymentStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderResponse {

    @Schema(name = "Id", description = "Identificador de pedido gerado automaticamente")
    private Long id;

    @Schema(name = "Product", description = "Nome do produto")
    private String product;

    @Schema(name = "Quantity", description = "Quantidade de produtos do pedido")
    private Integer quantity;

    @Schema(name = "Price", description = "Preço do produto por unidade")
    private Double price;

    @Schema(name = "Status", description = "Status de pagamento do pedido")
    private PaymentStatusEnum status;
}


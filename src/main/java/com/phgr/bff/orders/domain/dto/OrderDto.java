package com.phgr.bff.orders.domain.dto;

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
public class OrderDto {

    private Long id;
    private String product;
    private Integer quantity;
    private Double price;
    private PaymentStatusEnum status;
}


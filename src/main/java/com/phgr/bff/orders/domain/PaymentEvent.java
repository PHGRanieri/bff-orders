package com.phgr.bff.orders.domain;

import com.phgr.bff.orders.domain.enums.PaymentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEvent {
    private Long orderId;
    private PaymentStatusEnum status;
}
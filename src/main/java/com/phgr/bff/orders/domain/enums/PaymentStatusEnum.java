package com.phgr.bff.orders.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public enum PaymentStatusEnum {
    PENDING("Pending"),
    PAID("Paid"),

    CANCELLED("Cancelled");

    private final String value;
}

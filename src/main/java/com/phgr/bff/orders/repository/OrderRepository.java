package com.phgr.bff.orders.repository;

import com.phgr.bff.orders.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
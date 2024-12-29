package com.ifoodclone.IFood.Clone.oldversion.repository;

import com.ifoodclone.IFood.Clone.oldversion.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

package com.ifoodclone.IFood.Clone.repository;

import com.ifoodclone.IFood.Clone.domain.orderitem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

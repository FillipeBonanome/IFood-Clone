package com.ifoodclone.IFood.Clone.oldversion.repository;

import com.ifoodclone.IFood.Clone.oldversion.domain.orderitem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

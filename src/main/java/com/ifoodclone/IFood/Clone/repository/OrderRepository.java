package com.ifoodclone.IFood.Clone.repository;

import com.ifoodclone.IFood.Clone.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

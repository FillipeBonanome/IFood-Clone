package com.ifoodclone.IFood.Clone.oldversion.repository;

import com.ifoodclone.IFood.Clone.oldversion.domain.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByOwnerId(Long ownerId);
}

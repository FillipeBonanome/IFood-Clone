package com.ifoodclone.IFood.Clone.controller;

import com.ifoodclone.IFood.Clone.dto.restaurant.RestaurantDTO;
import com.ifoodclone.IFood.Clone.dto.restaurant.RestaurantRegisterDTO;
import com.ifoodclone.IFood.Clone.dto.user.UserListDTO;
import com.ifoodclone.IFood.Clone.infra.exception.RestaurantException;
import com.ifoodclone.IFood.Clone.repository.RestaurantRepository;
import com.ifoodclone.IFood.Clone.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> registerRestaurant(@RequestBody @Valid RestaurantRegisterDTO restaurant) throws RestaurantException {
        restaurantService.registerRestaurant(restaurant);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<RestaurantDTO>> getRestaurants(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = restaurantRepository.findAll(pageable).map(RestaurantDTO::new);
        return ResponseEntity.ok(page);
    }
}

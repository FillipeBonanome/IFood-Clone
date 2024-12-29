package com.ifoodclone.IFood.Clone.oldversion.controller;

import com.ifoodclone.IFood.Clone.oldversion.dto.restaurant.RestaurantDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.restaurant.RestaurantRegisterDTO;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.RestaurantException;
import com.ifoodclone.IFood.Clone.oldversion.repository.RestaurantRepository;
import com.ifoodclone.IFood.Clone.oldversion.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    @Transactional
    public ResponseEntity<RestaurantDTO> registerRestaurant(@RequestBody @Valid RestaurantRegisterDTO restaurant, UriComponentsBuilder uriBuilder) throws RestaurantException {
        var newRestaurant = restaurantService.registerRestaurant(restaurant);
        return ResponseEntity.created(uriBuilder.path("/restaurant/{id}").buildAndExpand(newRestaurant).toUri()).
                body(newRestaurant);
    }

    @GetMapping
    public ResponseEntity<Page<RestaurantDTO>> getRestaurants(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = restaurantRepository.findAll(pageable).map(RestaurantDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Long id) {
        var restaurant = restaurantRepository.getReferenceById(id);
        return ResponseEntity.ok(new RestaurantDTO(restaurant));
    }
}

package com.ifoodclone.IFood.Clone.oldversion.service;

import com.ifoodclone.IFood.Clone.oldversion.domain.menu.Menu;
import com.ifoodclone.IFood.Clone.oldversion.domain.menuitem.MenuItem;
import com.ifoodclone.IFood.Clone.oldversion.domain.restaurant.Restaurant;
import com.ifoodclone.IFood.Clone.oldversion.dto.menu.MenuDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.menu.MenuRegisterDTO;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.MenuException;
import com.ifoodclone.IFood.Clone.oldversion.repository.MenuRepository;
import com.ifoodclone.IFood.Clone.oldversion.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public MenuDTO registerMenu(MenuRegisterDTO menu) throws MenuException {
        var restaurant = getRestaurantById(menu.restaurantId());
        List<MenuItem> items = new ArrayList<>();
        var newMenu = new Menu(
                null,
                menu.name(),
                items,
                restaurant
        );
        var savedMenu = this.menuRepository.save(newMenu);
        return new MenuDTO(savedMenu);
    }

    public Restaurant getRestaurantById(Long id) throws MenuException {
        var restaurant = restaurantRepository.findById(id);
        if (restaurant.isEmpty()) {
            throw new MenuException("Restaurant not found");
        }
        return restaurant.get();
    }

}

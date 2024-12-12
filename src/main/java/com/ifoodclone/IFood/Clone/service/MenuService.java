package com.ifoodclone.IFood.Clone.service;

import com.ifoodclone.IFood.Clone.domain.menu.Menu;
import com.ifoodclone.IFood.Clone.domain.menuitem.MenuItem;
import com.ifoodclone.IFood.Clone.dto.menu.MenuDTO;
import com.ifoodclone.IFood.Clone.dto.menu.MenuRegisterDTO;
import com.ifoodclone.IFood.Clone.repository.MenuRepository;
import com.ifoodclone.IFood.Clone.repository.RestaurantRepository;
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

    public MenuDTO registerMenu(MenuRegisterDTO menu) {
        var restaurant = restaurantRepository.getReferenceById(menu.restaurantId());
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

}

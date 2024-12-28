package com.ifoodclone.IFood.Clone.service;

import com.ifoodclone.IFood.Clone.domain.menu.Menu;
import com.ifoodclone.IFood.Clone.domain.menuitem.MenuItem;
import com.ifoodclone.IFood.Clone.dto.menuitem.MenuItemDTO;
import com.ifoodclone.IFood.Clone.dto.menuitem.MenuItemRegisterDTO;
import com.ifoodclone.IFood.Clone.infra.exception.MenuItemException;
import com.ifoodclone.IFood.Clone.repository.MenuItemRepository;
import com.ifoodclone.IFood.Clone.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuRepository menuRepository;

    public MenuItemDTO registerMenuItem(MenuItemRegisterDTO menuItem) throws MenuItemException {
        var menu = getMenuById(menuItem.menuId());
        var newMenuItem = new MenuItem(null, menuItem.name(), menuItem.price(), menuItem.description(), menu);
        var savedMenuItem = menuItemRepository.save(newMenuItem);
        return new MenuItemDTO(savedMenuItem);
    }

    public Menu getMenuById(Long id) throws MenuItemException {
        var menu = menuRepository.findById(id);
        if (menu.isEmpty()) {
            throw new MenuItemException("Menu not found");
        }
        return menu.get();
    }

}

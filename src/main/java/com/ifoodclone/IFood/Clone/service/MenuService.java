package com.ifoodclone.IFood.Clone.service;

import com.ifoodclone.IFood.Clone.domain.menu.Menu;
import com.ifoodclone.IFood.Clone.dto.menu.MenuDTO;
import com.ifoodclone.IFood.Clone.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public MenuDTO registerMenu(MenuDTO menu) {
        var newMenu = new Menu(menu);
        var savedMenu = this.menuRepository.save(newMenu);
        return new MenuDTO(savedMenu);
    }

}

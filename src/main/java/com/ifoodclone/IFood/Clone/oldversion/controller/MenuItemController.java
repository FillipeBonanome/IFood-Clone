package com.ifoodclone.IFood.Clone.oldversion.controller;

import com.ifoodclone.IFood.Clone.oldversion.dto.menuitem.MenuItemDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.menuitem.MenuItemListDTO;
import com.ifoodclone.IFood.Clone.oldversion.dto.menuitem.MenuItemRegisterDTO;
import com.ifoodclone.IFood.Clone.oldversion.infra.exception.MenuItemException;
import com.ifoodclone.IFood.Clone.oldversion.repository.MenuItemRepository;
import com.ifoodclone.IFood.Clone.oldversion.service.MenuItemService;
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
@RequestMapping("/menu_item")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping
    public ResponseEntity<Page<MenuItemListDTO>> getMenuItems(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = menuItemRepository.findAll(pageable).map(MenuItemListDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDTO> getMenuItem(@PathVariable Long id) {
        var menuItem = menuItemRepository.getReferenceById(id);
        return ResponseEntity.ok(new MenuItemDTO(menuItem));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MenuItemDTO> registerMenuItem(@RequestBody @Valid MenuItemRegisterDTO menuItem, UriComponentsBuilder uriBuilder) throws MenuItemException {
        var newMenuItem = this.menuItemService.registerMenuItem(menuItem);
        return ResponseEntity.created(uriBuilder.path("/menu_item/{id}").buildAndExpand(newMenuItem.id()).toUri()).
                body(newMenuItem);
    }

}

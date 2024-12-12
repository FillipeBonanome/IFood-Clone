package com.ifoodclone.IFood.Clone.controller;

import com.ifoodclone.IFood.Clone.domain.menu.Menu;
import com.ifoodclone.IFood.Clone.dto.menu.MenuDTO;
import com.ifoodclone.IFood.Clone.dto.menu.MenuRegisterDTO;
import com.ifoodclone.IFood.Clone.dto.user.UserListDTO;
import com.ifoodclone.IFood.Clone.repository.MenuRepository;
import com.ifoodclone.IFood.Clone.service.MenuService;
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
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/{id}")
    public ResponseEntity<MenuDTO> getMenuById(@PathVariable Long id) {
        var menu = menuRepository.getReferenceById(id);
        return ResponseEntity.ok(new MenuDTO(menu));
    }

    @GetMapping
    public ResponseEntity<Page<MenuDTO>> getUsers(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = menuRepository.findAll(pageable).map(MenuDTO::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MenuDTO> registerMenu(@RequestBody @Valid MenuRegisterDTO menu, UriComponentsBuilder uriBuilder) {
        var newMenu = menuService.registerMenu(menu);
        return ResponseEntity.created(uriBuilder.path("/menu/{id}").buildAndExpand(newMenu.id()).toUri()).
                body(newMenu);
    }

}

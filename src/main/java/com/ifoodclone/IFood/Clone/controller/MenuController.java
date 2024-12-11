package com.ifoodclone.IFood.Clone.controller;

import com.ifoodclone.IFood.Clone.domain.menu.Menu;
import com.ifoodclone.IFood.Clone.dto.menu.MenuDTO;
import com.ifoodclone.IFood.Clone.repository.MenuRepository;
import com.ifoodclone.IFood.Clone.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    @Transactional
    public ResponseEntity<MenuDTO> registerMenu(@RequestBody @Valid MenuDTO menu, UriComponentsBuilder uriBuilder) {
        var newMenu = menuService.registerMenu(menu);
        return ResponseEntity.created(uriBuilder.path("/medicos/{id}").buildAndExpand(newMenu.id()).toUri()).
                body(newMenu);
    }

}

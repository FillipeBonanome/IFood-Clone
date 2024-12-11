package com.ifoodclone.IFood.Clone.repository;

import com.ifoodclone.IFood.Clone.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}

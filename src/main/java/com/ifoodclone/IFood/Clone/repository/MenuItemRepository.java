package com.ifoodclone.IFood.Clone.repository;

import com.ifoodclone.IFood.Clone.domain.menuitem.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}

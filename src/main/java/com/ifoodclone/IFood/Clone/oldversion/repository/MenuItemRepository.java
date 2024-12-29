package com.ifoodclone.IFood.Clone.oldversion.repository;

import com.ifoodclone.IFood.Clone.oldversion.domain.menuitem.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}

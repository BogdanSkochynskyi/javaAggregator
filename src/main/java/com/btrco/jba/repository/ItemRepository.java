package com.btrco.jba.repository;

import com.btrco.jba.entity.Item;
import com.btrco.jba.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>{
}

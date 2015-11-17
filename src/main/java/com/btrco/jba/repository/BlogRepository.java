package com.btrco.jba.repository;

import com.btrco.jba.entity.Blog;
import com.btrco.jba.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
}

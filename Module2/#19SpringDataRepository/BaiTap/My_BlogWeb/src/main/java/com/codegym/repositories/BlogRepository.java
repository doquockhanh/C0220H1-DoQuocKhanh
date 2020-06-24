package com.codegym.repositories;

import com.codegym.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findAllByTitleContainingAndCategory_Id(String keyword, Integer id, Pageable pageable);

    Page<Blog> findAllByCategory_Id(Integer id, Pageable pageable);

}

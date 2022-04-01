package com.shop.shopping.repository;

import com.shop.shopping.model.post.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
}

package com.jpademo.jpademoexposicion.repository;

import com.jpademo.jpademoexposicion.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
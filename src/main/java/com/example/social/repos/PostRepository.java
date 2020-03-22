package com.example.social.repos;

import com.example.social.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}

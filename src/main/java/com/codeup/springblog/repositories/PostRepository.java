package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
//    List<Object> findAllById();
//   List<Post> findAllById(Long i);

    // void deleteById(Long id);

}

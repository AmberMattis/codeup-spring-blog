package com.codeup.springblog.repositories;
import com.codeup.springblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

// also a part of the authentication process
    User findByUsername(String username);

}

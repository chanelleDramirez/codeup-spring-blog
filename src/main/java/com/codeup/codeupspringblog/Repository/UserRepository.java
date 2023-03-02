package com.codeup.codeupspringblog.Repository;

import com.codeup.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findById(long)

    User findByUsername(String username);

   // void save(User user); // this is a method created to accept the .save for Post Mapping on User Controller.

    User findById(long id);
}

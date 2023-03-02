package com.codeup.codeupspringblog.Repository;

import com.codeup.codeupspringblog.models.User;

public interface UserRepository {
//    User findById(long)

    User findByUsername(String username);

    void save(User user); // this is a method created to accept the .save for Post Mapping on User Controller.

    User findById(int i);
}

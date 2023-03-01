package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // id field

    public User(long id, String name){
        this.id = id;
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    @Column
    private String username; // username field

    public User() {

    }

    public String getName(){
        return username;
    }

    public void setName(){
        this.username = username;
    }

    @Column
    private String email; //email field
    @Column
    private String password; // password field

    public User(String email, String password){

        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")  // Implementing the use of Relationships here.
    private List<Post> posts;


    User user = userDao.getById(); // setting the user before the post is created
    Post post = new Post();
    post.setTitle("");
    post.setDescription("");
    post.setOwner(user);
    postDao.save(post);





}

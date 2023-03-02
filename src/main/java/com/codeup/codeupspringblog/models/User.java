package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // id field

    @Column
    private String username; // username field

    @Column
    private String email; //email field
    @Column
    private String password; // password field

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")  // Implementing the use of Relationships here.
    private List<Post> posts;

    public User(long id, String username){
        this.id = id;
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public User() {

    }

    public User(User copy) { //UserWithRoles uses this contructor
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public User(Long id, String username, String email, String password, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public User(String username, String email, String password, List<Post> posts) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }




    public String getUsername(){
        return username;
    }

    public void setUsername(){
        this.username = username;
    }


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




//    User user = userDao.getById(); // setting the user before the post is created
//    Post post = new Post();
//    post.setTitle("");
//    post.setDescription("");
//    post.setOwner(user);
//    postDao.save(post);
//
//
//


}

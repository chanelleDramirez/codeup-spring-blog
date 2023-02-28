package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Lines 11 to 20 are added because intellij said the persistent entity user should have a primary key.


    @Column
    private String name;


    @ManyToOne  // Implementing the use of Relationships here.
    @JoinColumn(name ="user_id")
    private User user;

    public User(){

    }

    public User(long id, String name){
    this.id = id;
    this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(){
         this.name = name;
    }
}

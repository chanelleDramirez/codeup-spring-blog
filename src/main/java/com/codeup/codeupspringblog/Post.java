package com.codeup.codeupspringblog;


public class Post {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}














//    private final PostRepository adDao;
//
//    public PostController(PostRepository adDao) {
//        this.adDao = adDao;
//    }
//public interface PostRepository extends JpaRepository<Post, Long> {
//
//
//}
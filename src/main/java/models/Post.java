package models;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Table(name="post") //Allows us to create a table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, length = 100) // Allows us to create a column
    private String title;

    @Column (nullable = false) // Allows us to create a column
    private String body;

    public Post(String title, String body) {  // title and body on PostController required a constructor.
    }

    public String getTitle() {
        return title;
    }  // Lines 18 to 31 are getters and setters for title and body.

    public void setTitle(String title) {
        this.title = title;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }









}


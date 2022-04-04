package pl.coderslab.book;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private String description;
    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;


}

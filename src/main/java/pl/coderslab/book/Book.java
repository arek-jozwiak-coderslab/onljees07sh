package pl.coderslab.book;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5)
    private String title;
    @Min(1)
    @Max(10)
    private int rating;
    @Size(max = 600)
    private String description;
    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

    @ManyToOne
    @NotNull
    private Publisher publisher;


}
